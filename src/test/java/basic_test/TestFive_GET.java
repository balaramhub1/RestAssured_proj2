package basic_test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestFive_GET {
	
	@Test(description="GET request to find an user by with id=5")
	public void Test_01_GET() {
		
		baseURI="https://gorest.co.in/public/v1";
		String endPoint="/users?id=5";
		
		given().
			get(endPoint).
		then().
			statusCode(200).
			body("data.name",hasItem("Darshan Mehra DC")).
			log().all();
		
	}
}
