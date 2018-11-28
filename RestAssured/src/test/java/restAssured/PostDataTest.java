package restAssured;

import static io.restassured.RestAssured.get;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDataTest {
  @Test
  public void postTest1() {
	  RequestSpecification  req= RestAssured.given();
	  req.header("Content-Type","application/json");
	  JSONObject jsn= new  JSONObject();
	  jsn.put( "name","sanjib");
	  jsn.put("job","leader");
	   req.body(jsn.toJSONString());
	  Response res= req.post("https://reqres.in/api/users/2");
	  // print all header
	  Headers allHeaders = res.headers();
	  // Iterate over all the Headers
		for(Header header : allHeaders){
			System.out.println( header.getName() + ": " + header.getValue());
		}
	  // print all body
		String data= res.asString();
		System.out.println("data  "+ data );
		String contentType = res.getHeader("Content-Type");
		System.out.println(contentType );
		String date = res.header("Date");
		System.out.println(date );
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		  JsonPath jsonPathEvaluator = res.jsonPath();
	  String job = jsonPathEvaluator.get("job");
	  Assert.assertEquals(job, "leader","not Correct job name received in the Response");
	   String name = jsonPathEvaluator.get("name");
	  Assert.assertEquals(name, "sanjib");
	  
	  int code=res.getStatusCode();
		System.out.println("status code "+ code );
		Assert.assertEquals(code,201);	
  }
}
