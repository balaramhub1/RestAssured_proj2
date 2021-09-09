package jsonSchema_test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class ValidateJsonSchema_01 {

	@Test
	public void Test_01_JSONSchema() {
		
		/*This class is to demonstrate the json schema validation.
		For this we have to create the json schema and place it in class path
		(refer documentation for the project).*/
		
		
		baseURI="https://reqres.in/api";
		String endPoint="/users?page=2";
		
		given().
			get(endPoint).
		then().
			assertThat().
			body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
			log().all();

	}
}
