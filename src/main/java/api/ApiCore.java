package api;

import java.io.FileReader;
import java.io.IOException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;


public class ApiCore {
		
		public Response PostLogin (String filePath, String URL) throws IOException, ParseException { 
			
			JSONParser json = new JSONParser();
			FileReader reader = new FileReader(filePath); 
			Object obj = json.parse(reader); 
			  
			org.json.simple.JSONObject requestParams = (org.json.simple.JSONObject) obj;
			  
			RestAssured.baseURI = "https://reqres.in/api"; 
			RequestSpecification httpRequest = RestAssured.given()
					.headers("Content-Type", "application/json")
					.body(requestParams.toString());
			  
			Response response = httpRequest.post(URL);
			Reporter.log("Json body: " + requestParams.toString());
			return response;	
			
		}

}
