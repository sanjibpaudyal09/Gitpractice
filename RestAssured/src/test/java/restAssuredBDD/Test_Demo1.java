package restAssuredBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_Demo1 {
  @Test
  public void Get_NumberOfCircuits() {
	  given().
	  when().
	//  get("http://ergast.com/api/f1/2017/circuits.json").
	  get("https://reqres.in/api/users/2").
	  then().
	  assertThat().
	 // body("MRData.CircuitTable.CircuitData.CircuitId",hasSize(20));
	 // body("data.id",hasSize(3)).
	   body("data.first_name",equalTo("Janet")).
	  
	  body("data.Last_name",equalTo("Bluth")).
	  and().
	  statusCode(200).and().
	 header("Content-Type",equalTo("application/json; charset=utf-8"));
	  
	  
	  
	  
  }
}
