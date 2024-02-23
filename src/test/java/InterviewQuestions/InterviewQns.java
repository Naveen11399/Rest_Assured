package InterviewQuestions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class InterviewQns {

	@Test
	public void getReqSpecValueFromCode() {

		// https://dev-schoolapi.izome.in/api/auth/institute-code-check
//		{
//		  "instituteCode": "9220117383"
//	}
////		

		RestAssured.baseURI = "https://dev-schoolapi.izome.in/api";
		RestAssured.basePath = "/auth/institute-code-check";

		RequestSpecification spec = RestAssured.given()
				.header("Content-Type", "application/json")
				.body("		{\r\n" + "		  \"instituteCode\": \"9220117383\"\r\n" + "	}");

		Response response = spec.request(Method.POST);

		QueryableRequestSpecification QRS = SpecificationQuerier.query(spec);

		System.out.println(QRS.getHeaders());

		System.out.println(QRS.getBaseUri());

		System.out.println(QRS.getBasePath());

	}

}
