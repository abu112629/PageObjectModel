package com.canadalife.automation.grsoe.api.salesforce;

import com.canadalife.automation.grsoe.api.salesforceassetpayload.AssetPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import ui.auto.core.support.EnvironmentsSetup;
import ui.auto.core.support.TestContext;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SalesforceUpdateAsset{

    ClientInfo clientInfo;

    public String updateAssetDetails(String body,String assetId) {

        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_asset_params = env.getCustom("salesforce_asset_params");
        return updateAssetDetails(baseURI,salesforce_asset_params,
                body,assetId);

    }

    public String updateAssetDetails(String baseURI,String salesforce_asset_params,
                                     String body,String assetId) {

        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();

        header.put("Authorization", "Bearer " + clientInfo.getAuthToken());
        Response response = RequestInfo.sendPatchRequest(baseURI,
                body,header,salesforce_asset_params+assetId);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_NO_CONTENT,
                response.getStatusCode());

        return response.asString();

    }

    public void updatedAssetDetails(String planId,String division){
        List<String> list = Arrays.asList("02i4g0000005xtzAAA",
                "02i4g000000c6WPAAY",
                "02i4g000000c6WeAAI",
                "02i4g000000c6WjAAI",
                "02i4g000000c6WoAAI",
                "02i4g000000c6WtAAI");
        String body =RequestInfo.GenerateStringFromResource("src/main/resources/requests/assetdetail.json");
        ObjectMapper objectmapper = new ObjectMapper();
        try{
            AssetPayload payload=objectmapper.readValue(body, AssetPayload.class);

            payload.setPlanIdC(planId);
            payload.setDivisionC(division);

            for (String s : list) {
                updateAssetDetails(objectmapper.writeValueAsString(payload),s);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}
