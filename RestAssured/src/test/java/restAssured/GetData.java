package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetData {
	@Test
	public void getResponseCode(){
		Response res= RestAssured.get("https://reqres.in/api/users/2");
		int code=res.getStatusCode();
		System.out.println("status code "+ code );
		Assert.assertEquals(code,200);
		
	}
	@Test
	public void testBody(){
		Response rbody= RestAssured.get("https://reqres.in/api/users/2");
		String data=rbody.asString();
		System.out.println("data is"+  data);
		System.out.println("response time "+ rbody.getTime());
	
		
	}

}
