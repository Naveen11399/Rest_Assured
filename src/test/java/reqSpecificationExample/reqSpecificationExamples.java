package reqSpecificationExample;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class reqSpecificationExamples {
	RequestSpecification reqSpec;

	@BeforeSuite
	public void setReqSpecification() {
		
		reqSpec=RestAssured.with()
		.baseUri("http://3.6.249.0")
		.basePath("/backend/api");
         RestAssured.requestSpecification=reqSpec;
		
		
	
		
	}
	
	@Test
	public void getRating1() {
		RestAssured.given()
		.when()
		.get("/product-store/get-product-rating-count?productId=2375")
		.prettyPrint();
		
	}
	

	@Test
	public void getWidgetDetails() {
		
		RestAssured.given()
		.when()
		.get("/list/widget-detail/todays-deals")
		.prettyPrint();
		
		
	}
	
	@Test
	public void postMethod() {
		
		//multiple req specification
		
		
		RequestSpecification RQS=RestAssured.given()
				.baseUri("https://api.picco.support/backend/api/")
				.basePath("auth/login")
				.header("Content-Type","application/json");
				
		
		RestAssured.given()
		.spec(RQS)
		.body("{\r\n"
				+ "  \"loginId\": \"harishkumar.harish1994@gmail.com\",\r\n"
				+ "  \"password\": \"Welcome123$\"\r\n"
				+ "}")
		.when()
		.post()
		.prettyPrint();
		
	
		
	}
	
	@Test
	public void reqSpecBuilder() {
		RequestSpecBuilder builder =new RequestSpecBuilder();
		
//		builder.setBaseUri("http://3.6.249.0");
//		builder.setBasePath("/backend/api");
//		
//		RequestSpecification spec=builder.build();
		
		//another method
		
	  RequestSpecification spec=	builder.setBaseUri("http://3.6.249.0").setBasePath("/backend/api").build();
		
		RestAssured.given(spec).get("/list/widget-detail/todays-deals").prettyPrint();
		
		
		
		
	}
	
	
	
}
