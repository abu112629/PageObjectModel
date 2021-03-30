package com.canadalife.automation.grsoe.api.salesforce;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class RequestInfo {

    public static String GenerateStringFromResource(String path){
        try{
            return new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(Exception e){
            return e.toString();
        }
    }
    public static Response sendPatchRequest(String baseURI, String body, Map<String, Object> header, String requestType) {

        Response response = null;

        try {
            RestAssured.baseURI = baseURI.toString();
            RequestSpecification request = RestAssured.given();
            request.headers(header).when().contentType(ContentType.JSON).body(body);

            response = request.patch(requestType);

        } catch (Exception e) {
            System.out.println(e);
        }

        return response;

    }

    public static Response sendGetRequest(String baseURI, String pathParams, Map<String, Object> header) {

        Response response = null;

        try {
            RestAssured.baseURI = baseURI.toString();
            RequestSpecification request = RestAssured.given();
            request.headers(header).when().relaxedHTTPSValidation("TLS");

            response = request.get(pathParams);

        } catch (Exception e) {
            System.out.println(e);
        }

        return response;

    }

    public static Response sendDeleteRequest(String baseURI, String pathParams, Map<String, Object> header) {

        Response response = null;

        try {
            RestAssured.baseURI = baseURI.toString();
            RequestSpecification request = RestAssured.given();
            request.headers(header).when().relaxedHTTPSValidation("TLS");

            response = request.delete(pathParams);

        } catch (Exception e) {
            System.out.println(e);
        }

        return response;

    }
}
