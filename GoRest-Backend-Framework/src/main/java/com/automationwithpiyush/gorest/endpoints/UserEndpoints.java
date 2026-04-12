package com.automationwithpiyush.gorest.endpoints;

import static io.restassured.RestAssured.given;

import com.automationwithpiyush.gorest.payloads.GorestUser;
import com.automationwithpiyush.gorest.utilities.ConfigReader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

    // You must generate your token at gorest.co.in and put it here
    private static final String AUTH_TOKEN = ConfigReader.getProperty("bearer_token");

    public static Response createGorestUser(GorestUser payload) {
        return given()
//        	.log().all()
            .header("Authorization", "Bearer " + AUTH_TOKEN)
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post(Routes.post_url);
    }

    public static Response getGorestUser(int userId) {
        return given()
            .header("Authorization", "Bearer " + AUTH_TOKEN)
            .pathParam("id", userId)
        .when()
            .get(Routes.get_url);
    }

    public static Response updateGorestUser(int userId, GorestUser payload) {
        return given()
            .header("Authorization", "Bearer " + AUTH_TOKEN)
            .contentType(ContentType.JSON)
            .pathParam("id", userId)
            .body(payload)
        .when()
            .put(Routes.put_url);
    }

    public static Response deleteGorestUser(int userId) {
        return given()
            .header("Authorization", "Bearer " + AUTH_TOKEN)
            .pathParam("id", userId)
        .when()
            .delete(Routes.delete_url);
    }
}