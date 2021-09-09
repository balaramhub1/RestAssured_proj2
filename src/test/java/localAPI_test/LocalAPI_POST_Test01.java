package localAPI_test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

import io.restassured.http.ContentType;

public class LocalAPI_POST_Test01 {
	
	@Test(description="POST request to add a user in users endpoint")
	public void Test_01_POST() {
		
		baseURI="http://localhost:3000";
		String endPoint="/users";
		
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("firstName", "Anjali");
		jsonReq.put("lastName", "Rout");
		jsonReq.put("subjectId", 5);
		// is will be auto generated, hence should not be part of the payload
		// jsonReq.put("id", 105);
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq).
		when().
			post(endPoint).
		then().
			statusCode(201).
			log().all();
		
	}
}
