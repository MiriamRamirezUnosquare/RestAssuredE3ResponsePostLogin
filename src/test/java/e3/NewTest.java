package e3;

import api.ApiCore;

import io.restassured.response.Response;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.Reporter;

public class NewTest {
	
	ApiCore apiCore; 
	
	@Test
	public void ApiPost() throws IOException, ParseException {
	
		Response test = apiCore.PostLogin(".\\Json\\Login.json","/login"); 
		Assert.assertEquals(200, test.statusCode()); 
	    
		String responseBody = test.getBody().asString();
		int responseStatusCode = test.getStatusCode();
		
		Reporter.log("Response body: " +responseBody);
		Reporter.log("Response code: " + String.valueOf(responseStatusCode));

	}
	
	@BeforeTest
	public void beforeTest() {
	
		apiCore = new ApiCore(); 
	
	}

}