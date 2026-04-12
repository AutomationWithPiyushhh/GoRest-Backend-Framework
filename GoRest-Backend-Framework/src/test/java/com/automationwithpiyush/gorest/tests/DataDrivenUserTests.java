package com.automationwithpiyush.gorest.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationwithpiyush.gorest.endpoints.UserEndpoints;
import com.automationwithpiyush.gorest.payloads.GorestUser;
import com.automationwithpiyush.gorest.utilities.ExcelReader;
import io.restassured.response.Response;

public class DataDrivenUserTests {
	@Test(priority = 1, dataProvider = "UserData")
	public void testPostUser(String name, String email, String gender, String status) {
		GorestUser userPayload = new GorestUser();
		userPayload.setName(name);

		// FIX: Add @example.com (or any domain) to make it a valid email format
		String uniqueEmail = "qa_" + System.currentTimeMillis() + "_" + email + "@example.com";
		userPayload.setEmail(uniqueEmail);

		userPayload.setGender(gender);
		userPayload.setStatus(status);

		Response response = UserEndpoints.createGorestUser(userPayload);

		// Log response on failure for easier debugging
		if (response.getStatusCode() != 201) {
			System.out.println("FAILED! Server Response: " + response.asPrettyString());
		}

		Assert.assertEquals(response.getStatusCode(), 201, "Expected status code 201 for User Creation");
	}
	

	@DataProvider(name = "UserData")
	public Object[][] getUserData() throws IOException {
		// Path to your externalized test data
		String path = System.getProperty("user.dir") + "//src//test//resources//UserTestData.xlsx";
		ExcelReader xl = new ExcelReader(path);

		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);

		Object[][] apiData = new Object[rownum][colcount];

		// Loop through Excel data and populate the 2D Object array
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				apiData[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}
}