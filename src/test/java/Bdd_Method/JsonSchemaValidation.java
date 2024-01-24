package Bdd_Method;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test
	public void validationUsingJSONSchemaValidation() {
		
		File file=new File("src/test/resources/postJsonFile.json");

		given()
		        .baseUri("http://3.6.249.0/backend/api")
				.header("Content-Type","application/json")
		        .body(file)
		.when()
		       .post("/list/contact-us")
		      
		       .then()
		       .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
		       .log().all();
		      
		      
		      

		       
		     
		      
	}
	

	@Test
	public void validationUsingJSONSchemaValidationWithoutClasspth() {
		
		File file=new File("src/test/resources/postJsonFile.json");
		
		File schemaFile=new File("src/test/resources/schema.json");

		given()
		        .baseUri("http://3.6.249.0/backend/api")
				.header("Content-Type","application/json")
		        .body(file)
		.when()
		       .post("/list/contact-us")
		      
		       .then()
		       .body(JsonSchemaValidator.matchesJsonSchema(schemaFile))
		       .log().all();
		      
		      
		      }

}
