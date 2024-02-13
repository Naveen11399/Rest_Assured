package Deserialization;




import java.io.File;
import java.util.Arrays;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.JsonOrgMappingProvider;

import io.restassured.common.mapper.TypeRef;

import static io.restassured.RestAssured.*;


public class deserializationMethod {
	
	String json = "{\r\n" + "  \"name\" : \"nk\",\r\n" + "  \"email\" : \"naveen\",\r\n"
			+ "  \"skills\" : [ \"joker\", \"hero\" ]\r\n" + "}";
	@Test
	public void deserial() {



		pojoClsMethod pojo = new pojoClsMethod();
		pojo.setName("thaththiram");
		pojo.setEmail("nk@gmail.com");
		pojo.setSkills(Arrays.asList("joker","looser"));
		
		
		System.out.println(pojo.getName());
		System.out.println(pojo.getEmail());
		System.out.println(pojo.getSkills());
		
		

	}
	
	@Test
	public void deserialization_UsingJaywayJsonPath() {
		
	
		
//		File json= new File("src/test/resources/BooksJson.json");
		
		JacksonMappingProvider mappingProvider=new JacksonMappingProvider();
		
		Configuration config= Configuration
				              .builder()
				              .mappingProvider(mappingProvider)
				              .build();
		
		
		pojoClsMethod pm=JsonPath.using(config).parse(json).read("$",pojoClsMethod.class);
		
		System.out.println(pm.getName());
		System.out.println(pm.getEmail());
		System.out.println(pm.getSkills());
	
		
		

	}
	
	@Test 
	public void usingRestAssuredJsonPath() {
		
		io.restassured.path.json.JsonPath jsonPath=io.restassured.path.json.JsonPath.from(json);
		
		pojoClsMethod pm=jsonPath.getObject("$", pojoClsMethod.class);
		
		System.out.println(pm.getName());
		System.out.println(pm.getEmail());
		System.out.println(pm.getSkills());
		
		
	}
	

	//http://3.6.249.0/backend/api/list/widget-detail/todays-deals
	
	@Test
		public void deserialization_UsingAsFunction() {
			
			
			Map<String, Object> res=	given()
			.baseUri("http://3.6.249.0/backend/api")
			.when()
			.get("/seo/product/syler-king")
			.then()
			.extract()
			.body()
			.as( new TypeRef <Map<String, Object>>() {
			});
			
			//System.out.println(res);
		
			
			System.out.println(res.get("message"));
	
		}
}