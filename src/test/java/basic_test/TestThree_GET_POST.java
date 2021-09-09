package basic_test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestThree_GET_POST {

	@Test(description = "GET request, Test to match single value of first_name from response.")
	public void Test_01_GET() {
		baseURI = "https://reqres.in/api";
		String endPoint = "/users?page=2";

		given().get(endPoint).then().statusCode(200).body("data[1].first_name", equalTo("Lindsay"));
	}

	@Test(description = "GET request, Test to match multiple values of first_name from response.")
	public void Test_02_GET() {
		baseURI = "https://reqres.in/api";
		String endPoint = "/users?page=2";

		given().get(endPoint).then().statusCode(200).
		/*
		 * The below line checks for all the entries of "first_name" in data and
		 * verifies if "Lindsay","Michael","Byron" are available in the response.
		 */
				body("data.first_name", hasItems("Lindsay", "Michael", "Byron"));
	}

	@Test(description = "POST request to add a new User")
	public void Test_03_POST() {
		baseURI = "https://reqres.in/api";
		String endPoint = "/users";

		/*
		 * As part of POST request we have to send a body in below format : 
		 * { 
		 * 	"name":"morpheus",
		 * 	"job": "leader" 
		 * }
		 * 
		 * And Expected response would be in below format: with status code as 201 - successful creation of resource.
		 * { 
		 * 	"name":"morpheus",
		 * 	"job":"leader",
		 * 	"id": "919",
		 * 	"createdAt": "2021-08-07T18:30:09.581Z" 
		 * }
		 */
		/*
		 * Creating a Map and passing the value as JSON string as request body, Can
		 * directly put the values to the request object ( jsonReq )
		 * 
		 * JSONObject jsReq=new JSONObject(); 
		 * jsReq.put("name", "Juliet");
		 * jsReq.put("job", "Romance");
		 */

		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("name", "Romeo");
		userMap.put("job", "Teacher");

		System.out.println(userMap);

		JSONObject jsonReq = new JSONObject(userMap);
		System.out.println(jsonReq);
		System.out.println(jsonReq.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq.toJSONString()).
		when().
			post(endPoint).
		then().
		statusCode(201).
		log().all();
	}
}
