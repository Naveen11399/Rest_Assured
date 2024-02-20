package authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class BasicAuth {
	
@Test
	public void basicAuth() {
		
	Response response =  RestAssured.given()
    .auth()
    .basic("AniAdmin", "Naveen11@")
    .baseUri("https://dev-schoolapi.izome.in/api/auth/login")
    .header("Content-Type", "application/json")
    .body("{\r\n"
    		+ "  \"userName\": \"AniAdmin\",\r\n"
    		+ "  \"password\": \"Welcome@123\",\r\n"
    		+ "  \"instituteCode\": \"U2FsdGVkX18blB2t128FOhSwIkwyuSE1r7Nmyxw/xOE=\",\r\n"
    		+ "  \"deviceType\": 1\r\n"
    		+ "}")
    .when()
    .post();
    
    
    String token = response.jsonPath().getString("data.token");
    int statusCode = response.getStatusCode();

    // Print the token and status code
    System.out.println("Token: " + token);
    System.out.println("Status Code: " + statusCode);
}
	
@Test
public void ApiKey() {
	
	

	        // Set base URI for the API
	        RestAssured.baseURI = "https://dev-schoolapi.izome.in/api";

	        // Define the API key
	        String apiKey = "U2FsdGVkX19oCyimvbyBtx42PCHzeqFKuNvkQcY9VncsEv+MPrOQohhqBILuHIYmPvaXKRS0BKNse/KL9JdxHA==";
	        String bearerToken = "U2FsdGVkX19o8N/yXyBN1xfX39OK2nSanzeXLppgEXRxB04UtyazO/akRUZjEkhKa45sO3N0oh2SI9hCffxmlu3yW62REG9cQ/aodG9q9yf7H0KN/nqcmlY6zbHMOgacUFzxYeNCAl+5mEwQoq0z+Bcbyc1OgroPCJuRV6SA1/hz3RTZlRhr5LEapgdWcCaIEQmesvuOiX9SKPb6bkZ31u8AG5wR98TlBDcAKhWLg58=";

	        // Make a GET request with the API key
	        Response response = RestAssured.given()
	            .header("Accessapikey", apiKey)
	            .header("Authorization", "Bearer " + bearerToken)
	            .get("/student/get-student/38");

	        // Print the response status code
	        System.out.println("Response Status Code: " + response.getStatusCode());

	        // Print the response body
	        System.out.println("Response Body: " + response.getBody().asString());
	  }

@Test
public void bearerToken() {
	
	  RestAssured.baseURI = "https://dev-schoolapi.izome.in/api";
	  
      String bearerToken = "U2FsdGVkX19o8N/yXyBN1xfX39OK2nSanzeXLppgEXRxB04UtyazO/akRUZjEkhKa45sO3N0oh2SI9hCffxmlu3yW62REG9cQ/aodG9q9yf7H0KN/nqcmlY6zbHMOgacUFzxYeNCAl+5mEwQoq0z+Bcbyc1OgroPCJuRV6SA1/hz3RTZlRhr5LEapgdWcCaIEQmesvuOiX9SKPb6bkZ31u8AG5wR98TlBDcAKhWLg58=";

    // Make a GET request with the API key
    Response response = RestAssured.given()
      
        .header("Authorization", "Bearer " + bearerToken)
        .get("/student/get-student/38");

    // Print the response status code
    System.out.println("Response Status Code: " + response.getStatusCode());

    // Print the response body
    System.out.println("Response Body: " + response.getBody().asString());
}


@Test
public void oAuth2() {
	
	  RestAssured.baseURI = "https://dev-schoolapi.izome.in/api";
	  
    String Token = "U2FsdGVkX19o8N/yXyBN1xfX39OK2nSanzeXLppgEXRxB04UtyazO/akRUZjEkhKa45sO3N0oh2SI9hCffxmlu3yW62REG9cQ/aodG9q9yf7H0KN/nqcmlY6zbHMOgacUFzxYeNCAl+5mEwQoq0z+Bcbyc1OgroPCJuRV6SA1/hz3RTZlRhr5LEapgdWcCaIEQmesvuOiX9SKPb6bkZ31u8AG5wR98TlBDcAKhWLg58=";

  // Make a GET request with the API key
  Response response = RestAssured.given()
    
    .auth()
    .oauth2(Token)
    .get("/student/get-student/38");

  // Print the response status code
  System.out.println("Response Status Code: " + response.getStatusCode());

  // Print the response body
  System.out.println("Response Body: " + response.getBody().asString());
}




}
