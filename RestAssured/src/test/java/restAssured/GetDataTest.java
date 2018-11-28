package restAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class GetDataTest {
	@Test
	public void getResponseCode(){
		
		int code=get("https://reqres.in/api/users/2").getStatusCode();
		System.out.println("status code "+ code );
		Assert.assertEquals(code,200);
		
	}
	@Test
	public void testBody(){
		
		String data=get("https://reqres.in/api/users/2").asString();
		System.out.println("data is"+  data);
		long time=get("https://reqres.in/api/users/2").getTime();
		System.out.println("response t "+ time);
	
		
	}

}
