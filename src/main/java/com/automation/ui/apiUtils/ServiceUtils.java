package com.automation.ui.apiUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ServiceUtils {

    public String sendPostRequest(String baseURL, String body) {
        Response response = RestAssured.given().baseUri(baseURL).contentType(ContentType.JSON).body(body).post().then().extract().response();
        return response.getBody().asString();
    }
}
