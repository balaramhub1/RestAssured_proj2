package localAPI_test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class LocalAPI_PATCH_Test01 {
	
	@Test(description="PATCH request to upate a user information based on id")
	public void Test_01_PATCH() {
		
		baseURI="http://localhost:3000";
		
		// Change information for user with id 102
		String endPoint="/users/102";
		
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("lastName", "Manu");
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq).
		when().
			patch(endPoint).
		then().
			statusCode(200).
			log().all();
		
	}
}
