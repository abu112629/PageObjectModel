package com.canadalife.automation.grsoe.api.salesforce;

import com.canadalife.automation.grsoe.api.salesforcebenepayload.Record_bene;
import com.canadalife.automation.grsoe.api.salesforcebenepayload.SalesforceBenePayload;
import com.canadalife.automation.grsoe.api.salesforcecontactpayload.Record;
import com.canadalife.automation.grsoe.api.salesforcecontactpayload.SalesforceRecordPayload;
import com.canadalife.automation.grsoe.api.salesforcetrusteepayload.Record_trustee;
import com.canadalife.automation.grsoe.api.salesforcetrusteepayload.SalesforceTrusteePayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
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

    public String getUserContactDetail(String FirstName) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_params = env.getCustom("salesforce_params");
        return getUserContactDetail(baseURI, salesforce_params, FirstName);
    }

    public String getUserBeneficiaryDetails(String EID) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_params = env.getCustom("salesforce_params_bene");
        return getUserBeneficiaryDetails(baseURI, salesforce_params,EID);
    }

    public String DeleteBeneficiaryDetails(String EID) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_params = env.getCustom("salesforce_delete_params");
        return DeleteBeneficiaryDetails(baseURI, salesforce_params,EID);
    }

    public String getUserTrusteeDetails(String EID) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_params = env.getCustom("salesforce_params_trustee");
        return getUserBeneficiaryDetails(baseURI, salesforce_params,EID);
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

    public String getUserContactDetail(String baseURI, String salesforce_params,
                                      String FirstName) {
        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();
        // Get auth token
        header.put("Authorization", "Bearer " + clientInfo.getAuthToken());
        Response response = RequestInfo.sendGetRequest(baseURI,
                salesforce_params + "'" + FirstName +"'", header);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_OK,
                response.getStatusCode());

        return response.asString();

    }

    public String getUserBeneficiaryDetails(String baseURI, String salesforce_params,
                                      String EID) {
        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();
        // Get auth token
        header.put("Authorization", "Bearer " + clientInfo.getAuthToken());
        Response response = RequestInfo.sendGetRequest(baseURI,
                salesforce_params + "'" + EID + "'", header);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_OK,
                response.getStatusCode());

        return response.asString();

    }

    public String DeleteBeneficiaryDetails(String baseURI, String salesforce_params,
                                            String EID) {
        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();
        // Get auth token
        header.put("Authorization", "Bearer " + clientInfo.getAuthToken());
        Response response = RequestInfo.sendDeleteRequest(baseURI,
                salesforce_params+EID, header);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_NO_CONTENT,
                response.getStatusCode());

        return response.asString();

    }
    public void deleteAllBeneficiaryDetails(String firstname,String lastname,float Allocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                int i=salepayload.getTotalSize();
                for (Record record : data) {
                    String EID = record.getEIDC();
                    DeleteBeneficiaryDetails(EID);
                    i=i--;
                }

            }
            else {
                Assert.assertTrue(salepayload.getTotalSize().equals(0));
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAllEstateOrgDetails(String firstname,float Allocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserContactDetail(firstname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                int i=salepayload.getTotalSize();
                for (Record record : data) {
                    if(record.getAccountId().contains("0014g000003oHCeAAM") ||
                            record.getAccountId().contains("0014g000003oHHDAA2")||
                    record.getAccountId().contains("0014g000003oGmtAAE")||
                    record.getAccountId().contains("0014g00000426AnAAI")){
                        String EID = record.getEIDC();
                        DeleteBeneficiaryDetails(EID);
                        i=i--;
                    }
                }

            }
            else {
                Assert.assertTrue(salepayload.getTotalSize().equals(0));
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void checkBeneficiaryDetails(String firstname,String lastname,float Allocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                for (Record record : data) {
                    if (record.getAccountId().contains("0014g000003oHCeAAM") ||
                            record.getAccountId().contains("0014g000003oHHDAA2") ||
                            record.getAccountId().contains("0014g000003oGmtAAE") ||
                            record.getAccountId().contains("0014g00000426AnAAI")) {
                        String EID = record.getEIDC();

                        SalesforceBenePayload payload = objectMapper.readValue(
                                getUserBeneficiaryDetails(EID), SalesforceBenePayload.class);
                        if (!payload.getTotalSize().equals(0)) {
                            List<Record_bene> data2 = payload.getRecords();
                            for (Record_bene record2 : data2) {
                                if (record2.getAssetRoleC().contains("Primary beneficiary")) {
                                    assertEquals(record2.getAllocationC(), Allocation);
                                    assertEquals(record2.getAssetRoleC(), "Primary beneficiary");
                                    assertEquals(record2.getRevocableC().booleanValue(), true);
                                } else if(record2.getAssetRoleC().contains("Successor holder")){
                                    assertEquals(record2.getAllocationC(), Allocation);
                                    assertEquals(record2.getAssetRoleC(), "Successor holder");
                                    assertEquals(record2.getRevocableC().booleanValue(), true);
                                }
                                else{
                                    assertEquals(record2.getAllocationC(), Allocation);
                                    assertEquals(record2.getAssetRoleC(), "Contingent beneficiary");
                                    assertEquals(record2.getRevocableC().booleanValue(), true);
                                }

                            }
                        }
                    }
                }
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
    public void checkBeneficiaryEstateOrgDetails(String firstname,float Allocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserContactDetail(firstname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                for (Record record : data) {
                    if (record.getAccountId().contains("0014g000003oHCeAAM") ||
                            record.getAccountId().contains("0014g000003oHHDAA2") ||
                            record.getAccountId().contains("0014g000003oGmtAAE") ||
                            record.getAccountId().contains("0014g00000426AnAAI")) {
                        String EID = record.getEIDC();

                        SalesforceBenePayload payload = objectMapper.readValue(
                                getUserBeneficiaryDetails(EID), SalesforceBenePayload.class);
                        if (!payload.getTotalSize().equals(0)) {
                            List<Record_bene> data2 = payload.getRecords();
                            for (Record_bene record2 : data2) {
                                if (record2.getAssetRoleC().contains("Primary beneficiary")) {
                                    assertEquals(record2.getAllocationC(), Allocation);
                                    assertEquals(record2.getAssetRoleC(), "Primary beneficiary");
                                    assertEquals(record2.getRevocableC().booleanValue(), true);
                                }
                            }
                        }
                    }
                }
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
    public void checkBeneficiaryDetailsDeleted(String firstname,String lastname,float Allocation) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                for (Record record : data) {
                    String EID = record.getEIDC();

                    SalesforceBenePayload payload = objectMapper.readValue(
                            getUserBeneficiaryDetails(EID), SalesforceBenePayload.class);
                    if (!payload.getTotalSize().equals(0)) {
                        List<Record_bene> data2 = payload.getRecords();
                        for (Record_bene record2 : data2) {
                            if(record2.getAssetRoleC().contains("Primary beneficiary")||
                                    record2.getAssetRoleC().contains("Successor holder")){
                                Assert.assertFalse(record.getAccountId().contains("0014g000003oHCeAAM") ||
                                        record.getAccountId().contains("0014g000003oHHDAA2") ||
                                        record.getAccountId().contains("0014g000003oGmtAAE") ||
                                        record.getAccountId().contains("0014g00000426AnAAI"));
                            }
                            else{
                                Assert.assertTrue(payload.getRecords().size() == 0);
                            }

                        }
                    }
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
    public void checkRevocableDetails(String firstname,String lastname,String value) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);

            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                for (Record record : data) {
                    String EID = record.getEIDC();

                    SalesforceBenePayload payload = objectMapper.readValue(
                            getUserBeneficiaryDetails(EID), SalesforceBenePayload.class);
                    if (!payload.getTotalSize().equals(0)) {
                        List<Record_bene> data2 = payload.getRecords();
                        for (Record_bene record2 : data2) {
                            if(value.equals(record2.getRevocableC().booleanValue())){
                                Assert.assertTrue(record2.getRevocableC().booleanValue(),value);
                            }

                        }
                    }
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
    public void checkTrusteeDetails(String firstname,String lastname,String trusteeFirstname,
    String trusteeLastname,String trusteeRelation) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SalesforceRecordPayload salepayload = objectMapper.readValue(
                    getUserSpouseDetail(firstname, lastname), SalesforceRecordPayload.class);
            if (!salepayload.getTotalSize().equals(0)) {
                List<Record> data = salepayload.getRecords();
                int i=0;
                for (Record record : data) {
                    String EID = record.getEIDC();
                    SalesforceTrusteePayload payload = objectMapper.readValue(
                            getUserTrusteeDetails(EID), SalesforceTrusteePayload.class);
                    if (!payload.getTotalSize().equals(0)) {
                        List<Record_trustee> data2 = payload.getRecords();
                        for (Record_trustee record2 : data2) {
                            if(trusteeFirstname.equals(record2.getTrusteeFirstNameC())){
                                assertEquals(record2.getTrusteeFirstNameC(), trusteeFirstname);
                                assertEquals(record2.getTrusteeLastNameC(),trusteeLastname);
                                assertEquals(record2.getTrusteeRelationshipC(),trusteeRelation);
                                break;
                            }
                            else{
                                i++;
                            }
                        }
                    }
                }

            }
        }

        catch (Exception e) {
            System.out.println(e);
        }


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
