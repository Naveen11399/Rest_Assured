package deserialiazeAnnotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonSetterDeSerialiazer {

	@Test
	public void JsonSetter() throws JsonMappingException, JsonProcessingException {
	String json="{\r\n"
			+ "  \"name\" : \"naveenuuu\",\r\n"
			+ "  \"character\" : \"Paithiyam\",\r\n"
			+ "  \"broken\" : 7\r\n"
			+ "}";
	ObjectMapper mapper=new ObjectMapper();
	jsonSetterpojo pojo=mapper.readValue(json, jsonSetterpojo.class);
	
	System.out.println(pojo.getId());
	
	}
}
