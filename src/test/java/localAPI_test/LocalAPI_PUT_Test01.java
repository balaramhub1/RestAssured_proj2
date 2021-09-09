package localAPI_test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class LocalAPI_PUT_Test01 {
	
	@Test(description="PUT request to update user information")
	public void Test_01_PUT() {
		
		baseURI="http://localhost:3000";
		String endPoint="/users/107";
		
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("firstName", "Rajiv");
		jsonReq.put("lastName", "Masand");
		jsonReq.put("subjectId", 5);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq).
		when().
			put(endPoint).
		then().
			statusCode(200).
			log().all();
	}
}
