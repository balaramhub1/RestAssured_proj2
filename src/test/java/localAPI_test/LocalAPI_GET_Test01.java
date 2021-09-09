package localAPI_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LocalAPI_GET_Test01 {
	
	/*A local api server is setup to test varius http methods.
	Its running at :   http://localhost:3000
	The db.json is located in userhome directory.*/
		
	@Test(description="GET request to fetch All data from local api")
	public void Test_01_GET() {
		baseURI="http://localhost:3000";
		String endPoint="/users";
		
		given().
			get(endPoint).
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test(description="GET request to fetch data of single user from local api")
	public void Test_02_GET() {
		
		/*To fetch data for any user, we may request data based on:
		firstName, lastName, subjectId or id the endPoint will be diff for each query type.
		For firstName, endPoint : http://localhost:3000/users?firstName=<firstName>
		For lastName, endPoint : http://localhost:3000/users?lastName=<lastName>
		For subjectId, endPoint : http://localhost:3000/users?subjectId=<subjectId>
		For id, endPoint : http://localhost:3000/users?id=<id>
*/			
		
		baseURI="http://localhost:3000";
		String endPoint="/users?firstName=Ranjan";
		
		given().
			get(endPoint).
		then().
			statusCode(200).
			//body("users[3].firstName", hasItem("Ranjan")).
			log().all();
	}
}
