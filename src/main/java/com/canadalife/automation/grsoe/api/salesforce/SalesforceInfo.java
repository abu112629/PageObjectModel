package com.canadalife.automation.grsoe.api.salesforce;

import com.canadalife.automation.grsoe.api.salesforcecontactpayload.Record;
import com.canadalife.automation.grsoe.api.salesforcecontactpayload.SalesforceRecordPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import ui.auto.core.support.EnvironmentsSetup;
import ui.auto.core.support.TestContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class SalesforceInfo {

    ClientInfo clientInfo;

    public String getUserSpouseDetail(String FirstName, String LastName) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_params = env.getCustom("salesforce_params");
        return getUserSpouseDetail(baseURI, salesforce_params, FirstName, LastName);
    }

    public String getUserSpouseDetail(String baseURI, String salesforce_params,
                                      String FirstName, String LastName) {
        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();
        // Get auth token
        header.put("Authorization", "Bearer " + clientInfo.getAuthToken());
        Response response = RequestInfo.sendGetRequest(baseURI,
                salesforce_params + "'" + FirstName + " " + LastName + "'", header);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_OK,
                response.getStatusCode());

        return response.asString();

    }

    public void checkSpouseRecordDetails(String firstname, String lastname) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            SalesforceRecordPayload payload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);
            if (!payload.getTotalSize().equals(0)) {
                List<Record> data = payload.getRecords();
                for (Record record : data) {
                    if (record.getAccountId().contains("0014g000003oHCeAAM") ||
                            record.getAccountId().contains("0014g000003oHHDAA2")) {
                        assertEquals(record.getName(), firstname + " " + lastname);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void checkSpouseRecordDeleted(String firstname, String lastname) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            SalesforceRecordPayload payload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);
            if (payload.getRecords().size() != 0) {
                List<Record> data = payload.getRecords();
                for (Record record : data) {
                    Assert.assertFalse(record.getAccountId().contains("0014g000003oHCeAAM") ||
                            record.getAccountId().contains("0014g000003oHHDAA2"));
                }
            } else {
                Assert.assertTrue(payload.getRecords().size() == 0);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
