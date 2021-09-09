package basic_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestOne_GET {
	
	/**
	 * 
	 * Example TestClass to Demonstrate GET request and get Responses.
	 * 
	 */

	@Test
	public void Test_01() {
		
		Response res= RestAssured.get("https://gorest.co.in/public/v1/users");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	@Test
	public void Test_02() {
		
		Response res= RestAssured.get("https://gorest.co.in/public/v1/users");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		Assert.assertEquals(res.getStatusCode(), 201);
	}
}
