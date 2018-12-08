package apiOps;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RedirectSpecification;
import javaOps.JavaOperations;
import io.restassured.path.json.JsonPath;

public class ApiOperations {

	Response resp;

	public void validateGet(String baseUrl) {

		try {
			given().get(baseUrl).then().statusCode(200).log().all();
			resp = RestAssured.get(baseUrl);
			// get(baseUrl).then().log().all();
			int statusCode = resp.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			Reporter.log("API hit is successful with status code 200");
		} catch (Exception e) {
			Reporter.log("API get has been failed so further tests cannot be performed.");
		}
	}

	public Response getResponse() {
		return resp;
	}

	public void validateKeysOnGet(String key) {

		ResponseBody respBody = resp.getBody();
		String respString = respBody.asString();

		try {
			Assert.assertTrue(respString.contains(key));
			Reporter.log("The key " + key + " is available in the response");
		} catch (Exception e) {
			Reporter.log("The assertion failed as the key " + key + " doesn't exist in the received response");
		}

	}

	public void validateValuesOfKeys(String key) {

		ResponseBody respBody = resp.getBody();
		String respString = respBody.asString();

		try {
			Assert.assertTrue(respString.contains(key));
			Reporter.log("The " + key + " value is, " + respBody.jsonPath().getJsonObject(key));
		} catch (Exception e) {
			Reporter.log("The assertion failed as the key " + key + " doesn't exist in the received response");
		}

	}

	public void validateObjectSize(String key) {

		ResponseBody respBody = resp.getBody();

		try {
			List<String> jsonResponse = resp.jsonPath().getList(key);
			Reporter.log("Size of the object " + key + " is " + jsonResponse.size());

		} catch (Exception e) {
			Reporter.log("This key " + key + " doesn't have data");
			Assert.assertFalse(1 == 1);
		}

	}

	public void getObjectValueList(String key) {

		ResponseBody respBody = resp.getBody();

		try {
			Reporter.log("The " + key + " value is, " + respBody.jsonPath().getJsonObject(key));

		} catch (Exception e) {
			Reporter.log("The assertion failed as the key " + key + " doesn't exist in the received response");
			Assert.assertFalse(1 == 1);
		}
	}

	public void validateResponseObjectTypeOfLatitude() {
		JavaOperations javaops = resp.as(JavaOperations.class);
		if (Float.class.isInstance(javaops.getLatitude())) {
			Reporter.log("Latitude key is a float type and value is, " + javaops.getLatitude());
		} else {
			Reporter.log("Latitude is not float");
		}
	}

	public void validateResponseObjectTypesOfLongitude() {
		JavaOperations javaops = resp.as(JavaOperations.class);
		if (Float.class.isInstance(javaops.getLongitude())) {
			Reporter.log("Longitude key is a float type and value is, " + javaops.getLongitude());
		} else {
			Reporter.log("Longitude is not float");
		}
	}

	public void validateResponseObjectTypeOfTimezone() {
		JavaOperations javaops = resp.as(JavaOperations.class);
		if (String.class.isInstance(javaops.getCurrently())) {
			Reporter.log("Timezone key is a String type and value is, " + javaops.gettimezone());
		} else {
			Reporter.log("Timezone is not String");
		}
	}
	
	public void validateResponseObjectTypeOfOffset() {
		JavaOperations javaops = resp.as(JavaOperations.class);
		if (Integer.class.isInstance(javaops.getOffset())) {
			Reporter.log("Offset key is a Integer type and value is, " + javaops.getOffset());
		} else {
			Reporter.log("Offset is not Integer");
		}
	}
	
	
}
