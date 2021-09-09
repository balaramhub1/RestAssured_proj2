package basic_test;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class TestFour_PUT_PATCH_DELETE {
	
	@Test(description = "PUT request to update information of any User")
	public void Test_01_PUT() {
		baseURI = "https://reqres.in/api";
		String endPoint="/users/2";
		
		/*PUT is a update request where in we need to provide the body in json format:
			{
		    	"name": "morpheus",
		    	"job": "zion resident"
			}
		
		And a Response in below format is expected , with status code - 200
			{
		    	"name": "morpheus",
		    	"job": "zion resident",
		    	"updatedAt": "2021-08-07T19:07:25.898Z"
			}*/
		
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("name", "Romeo");
		jsonReq.put("job", "Joker");
		
		given().
			header("Content-Type","applicaiton/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq).
		when().
			put(endPoint).
		then().
			statusCode(200).
			log().all();
		
		
	}

	@Test(description = "PATCH request to update information of any User")
	public void Test_02_PATCH() {
		
		baseURI = "https://reqres.in/api";
		String endPoint="/users/2";
		
		/*PATCH is a update request where in we need to provide the body in json format:
		{
	    	"name": "morpheus",
	    	"job": "zion resident"
		}
	
	And a Response in below format is expected , with status code - 200
		{
	    	"name": "morpheus",
	    	"job": "zion resident",
	    	"updatedAt": "2021-08-07T19:07:25.898Z"
		}*/
		
		JSONObject jsonReq=new JSONObject();
		jsonReq.put("name", "Romeo");
		jsonReq.put("job", "Poker");
		
		given().
			header("Content-Type","applicaiton/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(jsonReq).
		when().
			patch(endPoint).
		then().
			statusCode(200).
			log().all();
	}

	@Test(description = "DELETE request to update information of any User")
	public void Test_03_DELETE() {
		
		baseURI = "https://reqres.in/api";
		String endPoint="/users/2";
		
		/*DELETE is a delete request 
		 * 	
			And a Response code is , with status code - 204
		*/
				
		given().
		when().
			delete(endPoint).
		then().
			statusCode(204).
			log().all();
	}
}
