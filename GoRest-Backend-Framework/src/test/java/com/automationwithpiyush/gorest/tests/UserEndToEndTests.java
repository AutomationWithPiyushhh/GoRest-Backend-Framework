package com.automationwithpiyush.gorest.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationwithpiyush.gorest.endpoints.UserEndpoints;
import com.automationwithpiyush.gorest.payloads.GorestUser;

import io.restassured.response.Response;

public class UserEndToEndTests {
    GorestUser userPayload;

    @BeforeClass
    public void setup() {
        userPayload = new GorestUser();
        userPayload.setName("Piyush Automation");
        userPayload.setEmail("piyush.qa." + System.currentTimeMillis() + "@example.com");
        userPayload.setGender("male");
        userPayload.setStatus("active");
    }

    @Test(priority = 1)
    public void testCreateUser() {
        Response response = UserEndpoints.createGorestUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 201);
        userPayload.setId(response.jsonPath().getInt("id"));
    }

    @Test(priority = 2, dependsOnMethods = "testCreateUser")
    public void testGetUserDetails() {
        Response response = UserEndpoints.getGorestUser(userPayload.getId());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "Piyush Automation");
    }

    @Test(priority = 3, dependsOnMethods = "testCreateUser")
    public void testUpdateUser() {
        userPayload.setName("Piyush Baldaniya - Senior QA");
        Response response = UserEndpoints.updateGorestUser(userPayload.getId(), userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4, dependsOnMethods = "testCreateUser")
    public void testDeleteUser() {
        Response response = UserEndpoints.deleteGorestUser(userPayload.getId());
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}