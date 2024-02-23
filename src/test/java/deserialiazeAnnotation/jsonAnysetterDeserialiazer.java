package deserialiazeAnnotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonAnysetterDeserialiazer {
	
	@Test
	public void jsonAnySetter() throws JsonMappingException, JsonProcessingException {

	String json = "{\r\n"
			+ "  \"name\": \"naveenuuu\",\r\n"
			+ "  \"email\": \"naveen@cc.cc\",\r\n"
			+ "  \"phoneNumber\": \"09916190866\",\r\n"
			+ "  \"message\": \"Follow U r Heart\"\r\n"
			+ "}";
	
	ObjectMapper mapper =new ObjectMapper();
	
	jsonAnySetterPojo pojo=	mapper.readValue(json, jsonAnySetterPojo.class);
	
	System.out.println(pojo.getContact());
	
	
			
	}
}
