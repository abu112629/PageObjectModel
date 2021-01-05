package com.canadalife.automation.grsoe.api.salesforce;

import com.canadalife.automation.grsoe.api.salesforcelanguagepayload.LanguagePayload;
import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import ui.auto.core.support.EnvironmentsSetup;
import ui.auto.core.support.TestContext;

import java.util.HashMap;
import java.util.Map;
import static org.testng.AssertJUnit.assertEquals;

import static com.canadalife.automation.grsoe.api.salesforce.RequestInfo.GenerateStringFromResource;
import static com.canadalife.automation.grsoe.api.salesforce.RequestInfo.sendPatchRequest;

public class SalesforceUpdateLanguage{

    ClientInfo clientInfo;

    public String updateUserlanguage(String body) {
        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String salesforce_language_params = env.getCustom("salesforce_language_params");
        return updateUserlanguage(baseURI, salesforce_language_params, body);
    }

    public String updateUserlanguage(String baseURI,String salesforce_language_params,String body) {

        clientInfo=new ClientInfo();
        Map<String, Object> header = new HashMap<String, Object>();

        header.put("Authorization", "Bearer " +  clientInfo.getAuthToken());
        Response response = sendPatchRequest(baseURI,
                body,header,salesforce_language_params);

        assertEquals("No details found. Error : " + response.asString(), HttpStatus.SC_NO_CONTENT,
                response.getStatusCode());

        return response.asString();

    }


    public void updateLanguage(String user_role){

        try{
            String body = GenerateStringFromResource("src/main/resources/requests/language.json");
            ObjectMapper objectmapper = new ObjectMapper();
            LanguagePayload payload = objectmapper.readValue(body, LanguagePayload.class);
            switch(user_role) {
                case "User_Cont_Eng":
                    payload.setLanguageLocaleKey("en_US");
                    break;
                case "User_Cont_Fr":
                    payload.setLanguageLocaleKey("fr");
                    break;

            }
            updateUserlanguage(objectmapper.writeValueAsString(payload));
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

}
