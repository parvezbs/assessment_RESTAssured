package getMethods;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import apiOps.ApiOperations;
import javaOps.JavaOperations;

public class getClass {

	ApiOperations apiops;
	// JavaOperations javaops;
	String baseUrl = "https://api.darksky.net/forecast/0f11f97b79268c7d1f184a77c8d3acc9/37.8267,-122.4233";

	@BeforeTest
	public void validateApiGatewayReadiness() {
		apiops = new ApiOperations();
		// javaops = new JavaOperations();
		apiops.validateGet(baseUrl);
		apiops.getResponse();
	}

	@Test
	public void validateResponsekeysArePresent() {
		apiops.validateKeysOnGet("latitude");
		apiops.validateKeysOnGet("longitude");
		apiops.validateKeysOnGet("currently");
		apiops.validateKeysOnGet("minutely");
		apiops.validateKeysOnGet("hourly");
		apiops.validateKeysOnGet("daily");
		apiops.validateKeysOnGet("flags");
		apiops.validateKeysOnGet("offset");
		apiops.validateKeysOnGet("timezone");
	}

	@Test
	public void validateResponseObjectSize() {
		apiops.validateObjectSize("minutely.data");
		apiops.validateObjectSize("hourly.data");
		apiops.validateObjectSize("daily.data");
	}

	@Test
	public void validateResponseObjectTypeOfLatitude() {
		Response resp = RestAssured.get(baseUrl);
		JavaOperations javaops = resp.as(JavaOperations.class);
		try {
			Assert.assertEquals(javaops.getLatitude(), 37.8267);
			Reporter.log("Latitude is float type");
		} catch (Exception e) {
			Reporter.log("Latitude is not float type");
		}
	}

	@Test
	public void validateResponseObjectTypesOfLongitude() {
		Response resp = RestAssured.get(baseUrl);
		JavaOperations javaops = resp.as(JavaOperations.class);
		try {
			Assert.assertEquals(javaops.getLongitude(), -122.4233);
			Reporter.log("Longitude is float type");
		} catch (Exception e) {
			Reporter.log("Longitude is not float type");
		}
	}

	@Test
	public void validateResponseObjectTypeOfOffset() {
		Response resp = RestAssured.get(baseUrl);
		JavaOperations javaops = resp.as(JavaOperations.class);
		try {
			Assert.assertEquals(javaops.getOffset(), -8);
			Reporter.log("Longitude is Integer type");
		} catch (Exception e) {
			Reporter.log("Longitude is not Integer type");
		}
	}

	@Test
	public void validateResponseObjectTypeTimezone() {
		Response resp = RestAssured.get(baseUrl);
		JavaOperations javaops = resp.as(JavaOperations.class);
		try {
			Assert.assertEquals(javaops.gettimezone(), "America/Los_Angeles");
			Reporter.log("Longitude is String type");
		} catch (Exception e) {
			Reporter.log("Longitude is not String type");
		}
	}
	@Test
	public void validateResposevalueOfAnArrayInTime(){
		apiops.getObjectValueList("currently.time");
	}
}
/*	@Test
	public void validateDataTypesOfJSONObjects() {
		apiops.validateResponseObjectTypeOfLatitude();
		apiops.validateResponseObjectTypesOfLongitude();
		apiops.validateResponseObjectTypeOfCurrently();
		apiops.validateResponseObjectTypeOfTimezone();
	}*/
/*
 * @Test public void validateResponseObjectTypeOfLatitude() { Response resp =
 * RestAssured.get(baseUrl); JavaOperations javaops =
 * resp.as(JavaOperations.class); if
 * (Float.class.isInstance(javaops.getLatitude())) {
 * Reporter.log("Latitude key is a float type and value is, " +
 * javaops.getLatitude()); } else { Reporter.log("Latitude is not float"); } }
 * 
 * @Test public void validateResponseObjectTypesOfLongitude() { Response resp =
 * RestAssured.get(baseUrl); JavaOperations javaops =
 * resp.as(JavaOperations.class); if
 * (Float.class.isInstance(javaops.getLongitude())) {
 * Reporter.log("Longitude key is a float type and value is, " +
 * javaops.getLongitude()); } else { Reporter.log("Longitude is not float"); } }
 * 
 * @Test public void validateResponseObjectTypeOfCurrently() { Response resp =
 * RestAssured.get(baseUrl); JavaOperations javaops =
 * resp.as(JavaOperations.class); if
 * (String.class.isInstance(javaops.getLatitude())) {
 * Reporter.log("Latitude key is a float type and value is, " +
 * javaops.getLatitude()); } else { Reporter.log("Latitude is not float"); } }
 */