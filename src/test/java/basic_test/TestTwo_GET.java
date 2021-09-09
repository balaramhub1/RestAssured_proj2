package basic_test;

import org.testng.annotations.Test;
/*
 *In order to use REST assured effectively it's recommended to statically import methods from the following classes: 
 */
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * If you want to use Json Schema validation you should also statically import these methods:
 */
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestTwo_GET {
	
	/**
	 * 
	 * Creating another test BDD style , by importing some static imports 
	 * from https://github.com/rest-assured/rest-assured/wiki/Usage
	 * 
	 * API endpoint used : https://gorest.co.in/public/v1/todos
	 * 
	 * Can use JSON path finder or its chrome plugin to find elments in the JSON response.
	 */
	
	
	@Test(description="GET request to verify id")
	public void Test_01() {
		baseURI="https://gorest.co.in/public/v1";
		given().
			get("/todos").
		then().
			statusCode(200).
			body("data[1].id", equalTo(2)).
			log().all();
	}
}
