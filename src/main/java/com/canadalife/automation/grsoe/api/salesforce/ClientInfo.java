package com.canadalife.automation.grsoe.api.salesforce;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import ui.auto.core.support.EnvironmentsSetup;
import ui.auto.core.support.TestContext;

import static org.testng.AssertJUnit.assertEquals;

public class ClientInfo {

    public String getAuthToken() {
        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String baseURI = env.getCustom("baseURI");
        String clientId = env.getCustom("CLIENT_ID");
        String clientSecret = env.getCustom("CLIENT_SECRET");

        String userName = System.getenv("AUTH_USERNAME");
        String password = System.getenv("AUTH_PASSWORD");
        return getAuthToken(baseURI,clientId, clientSecret,
                userName, password);
    }

    public String getAuthToken(String baseURI,
                               String clientID, String clientSecret,
                               String username, String password) {
        Response response = null;
        try {

            RestAssured.baseURI = baseURI.toString();
            RequestSpecification request = RestAssured.given();

            request.config(RestAssured.config().encoderConfig(
                    EncoderConfig.encoderConfig().encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .formParam("grant_type", "password")
                    .formParam("client_id", clientID).formParam("client_secret", clientSecret)
                    .formParam("username", username)
                    .formParam("password", password);

            response = request.post("/services/oauth2/token");
            assertEquals("Auth token is not created. Error : " + response.asString(), HttpStatus.SC_OK,
                    response.getStatusCode());

        } catch (Exception e) {
            System.out.println(e);
        }

        return response.jsonPath().getString("access_token");

    }


}


