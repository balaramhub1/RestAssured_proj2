package localAPI_test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LocalAPI_DELETE_Test01 {
	
	@Test
	public void Test_01_DELETE() {
		
		baseURI="http://localhost:3000";
		
		// Change information for user with id 102
		String endPoint="/users/108";
		
		given().
		when().
			delete(endPoint).
		then().
			statusCode(200).
			log().all();
		
	}
}
