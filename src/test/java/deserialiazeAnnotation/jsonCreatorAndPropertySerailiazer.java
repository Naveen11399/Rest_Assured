package deserialiazeAnnotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonCreatorAndPropertySerailiazer {
	
	@Test
	public void jsonCreatorAndProperty() throws JsonMappingException, JsonProcessingException {
	String json="{\r\n"
			+ "  \"name\" : \"naveenuuu\",\r\n"
			+ "  \"character\" : \"Paithiyam\",\r\n"
			+ "  \"broken\" : 7\r\n"
			+ "}";
	ObjectMapper mapper=new ObjectMapper();
	jsonCreatorAndPropertyPojo pojo1=mapper.readValue(json, jsonCreatorAndPropertyPojo.class);
	
	System.out.println(pojo1.getId());
	System.out.println(pojo1.getName());
	System.out.println(pojo1.getCharacter());
	
	}

}
