package non_BDD_Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getMethodBasic {

	@Test
	public void getProductApi() {

		RestAssured.baseURI = "http://3.6.249.0/backend/api";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification.request(Method.GET,
				"/store-product-attributes/product-detail/2240?id=2240");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

	}
	
	@Test
	public void postApiBasic() {
		
		RestAssured.baseURI="http://3.6.249.0/backend/api";
		RequestSpecification rs=RestAssured.given()
				.header("Content-Type","application/json")
	            .body("{\r\n"
	            		+ "  \"emailId\": \"jd@gmail.com\",\r\n"
	            		+ "  \"password\": \"Naveen11@\",\r\n"
	            		+ "  \"type\": \"normal\"\r\n"
	            		+ "}");
		
		Response response= rs.request(Method.POST,"/customer/login");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

		
	}
	
	@Test
	public void putApiBasic() {
		
		RestAssured.baseURI="http://3.6.249.0/backend/api";
		RequestSpecification rs=RestAssured.given()
				.header("Content-Type","application/json")
				//.auth().basic("jd@gmail.com", "Naveen11@")
			.auth().oauth2("U2FsdGVkX1/dVSbYh9PFE5FZ/p395qSO3yi85kOaQITIOb4Sy20nFyyEaHJJmadouLM06UOEh91Rih8TdiPYR4rmQMppw8y87Ec0fsoI6Cn9lERt5z0HmQcMxnMbKCTZuQ+VXf2BXRi+2UVz0FQS234tw2F9v94EVBeDJnem2GnADjy0N+DTzZUN7CXYT6rBQz0bee0CVPMvhhWkahyD5A==\",")
	            .body("{\r\n"
	            		+ "  \"company\": \"test login\",\r\n"
	            		+ "  \"address1\": \"naveen chennai 2\",\r\n"
	            		+ "  \"address2\": \"naveen, Tamil Nadu, India navee\",\r\n"
	            		+ "  \"city\": \" Chennai\",\r\n"
	            		+ "  \"state\": \"31\",\r\n"
	            		+ "  \"postcode\": \"600042\",\r\n"
	            		+ "  \"countryId\": 102,\r\n"
	            		+ "  \"addressType\": 1,\r\n"
	            		+ "  \"addressId\": \"1724\"\r\n"
	            		+ "}");
	   
		Response response= rs.request(Method.PUT,"/CustomerAddress/update-address/1724");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

		
	}
	
	@Test
	public void deleteApiBasic() {
		
		RestAssured.baseURI="http://3.6.249.0/backend/api";
		RequestSpecification rs=RestAssured.given()
				.header("Content-Type","application/json")
				//.auth().basic("jd@gmail.com", "Naveen11@")
			.auth().oauth2("U2FsdGVkX1+AC1IkST4ZN0635RtgAcO+vf7pd0yQWE8UAVR+MZS8nE6qPkYdM+a0cMV3YvFhWwQmsLrhX7cBna+zfYCZ8pMo1rzPYYRdrxQT4V2snl/9++Uj/vDEb+WvNjdGOF2d+SndsYLRvKJpOqf5cN5oP1bDju52UK2VR4htJFcGdfVx6r5qmpMhM3fn+LspZP235n3t2RTInkS02w==");
	   
		Response response= rs.request(Method.DELETE,"/CustomerAddress/delete-address/1782");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

		
	}

}
