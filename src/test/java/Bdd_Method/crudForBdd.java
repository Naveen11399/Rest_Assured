package Bdd_Method;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class crudForBdd {
	@Test
	public void getProduct() {
		
		
		 given()
		.baseUri("http://3.6.249.0/backend/api")
		.when()
		.get("/store-product-attributes/product-detail/2240?id=2240")
		.prettyPrint();
	}
	
	
@Test
	public void postMethod() {
	

	given()
	        .baseUri("http://3.6.249.0/backend/api")
			.header("Content-Type","application/json")
            .body("{\r\n"
            		+ "  \"emailId\": \"jd@gmail.com\",\r\n"
            		+ "  \"password\": \"Naveen11@\",\r\n"
            		+ "  \"type\": \"normal\"\r\n"
            		+ "}")
   .when()
	       .post("/customer/login")
	       .prettyPrint();
	
	
		
	}


@Test
public void putMethod() {


given()
        .baseUri("http://3.6.249.0/backend/api")
		.header("Content-Type","application/json")
        .body("{\r\n"
        		+ "  \"emailId\": \"jd@gmail.com\",\r\n"
        		+ "  \"password\": \"Naveen11@\",\r\n"
        		+ "  \"type\": \"normal\"\r\n"
        		+ "}")
.when()
       .put("/customer/login")
       .prettyPrint();


	
}

@Test
public void deleteMethod() {


given()
        .baseUri("http://3.6.249.0/backend/api")
		.header("Content-Type","application/json")
      .auth().oauth2("U2FsdGVkX1+AC1IkST4ZN0635RtgAcO+vf7pd0yQWE8UAVR+MZS8nE6qPkYdM+a0cMV3YvFhWwQmsLrhX7cBna+zfYCZ8pMo1rzPYYRdrxQT4V2snl/9++Uj/vDEb+WvNjdGOF2d+SndsYLRvKJpOqf5cN5oP1bDju52UK2VR4htJFcGdfVx6r5qmpMhM3fn+LspZP235n3t2RTInkS02w==")
.when()
       .delete("/CustomerAddress/delete-address/1782")
       .prettyPrint();


	
}


@Test
public void postMethodFromJsonFile() {
File file=new File("src/test/resources/postJsonFile.json");

given()
        .baseUri("http://3.6.249.0/backend/api")
		.header("Content-Type","application/json")
        .body(file)
.when()
       .post("/customer/login")
       .prettyPrint();


	
}

@Test
public void postMethodFromJacksonBind() {
	
	//Serailiaze method is using in this method like text is convert to json body by using jackson-databind dependency
	
	Map<String,Object> jsonBody= new HashMap<String,Object>();
	List<String> skills=new ArrayList<String>();
	skills.add("java naveen");
	skills.add("selenium");
	

	jsonBody.put( "name","naveen");
	jsonBody.put("message",skills);
	jsonBody.put( "email","naveen@gmail.com");
	jsonBody.put( "phoneNumber","09916190866.com");

	System.out.println(jsonBody);
			 

given()
        .baseUri("http://3.6.249.0/backend/api")
		.header("Content-Type","application/json")
		
        .body(jsonBody)
        .log()
        .all()
.when()
       .post("/list/contact-us")
      .then()
      .log()
      .all();
      


}




}
