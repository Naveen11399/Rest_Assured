package deserialiazeAnnotation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class jacksOnInjectDeserialiazer {

	
	@Test
	public void jacksOnInject() throws IOException {

		String json = "{\r\n" + "	\"firstName\": \"naveen\",\r\n" + "	\"emailId\": \"piccotalent169@gmail.com\"\r\n"
				+ "}";

		InjectableValues values = new InjectableValues.Std()
				.addValue(String.class, "unlucky");

		ObjectMapper mapper = new ObjectMapper();

		ObjectReader reader = mapper.reader(values);
		
		jacksOnInjectPojo pojo=	reader.readValue(json, jacksOnInjectPojo.class);
		
		System.out.println(pojo.getNickName());
		 

	}
	
	@Test
	public void JsonAliasAnnotation() throws JsonMappingException, JsonProcessingException {
		
		String json="{\r\n"
				+ "  \"name\" : \"naveenuuu\",\r\n"
				+ "  \"character\" : \"Paithiyam\",\r\n"
				+ "  \"JD\" : 7\r\n"
				+ "}";
		
		
	//	jsonAliasPojo pojo=	new ObjectMapper().readerFor(jsonAliasPojo.class).readValue(json);
		
		ObjectMapper mapper = new ObjectMapper();
		
		jsonAliasPojo pojo=mapper.readValue(json, jsonAliasPojo.class);
		
		System.out.println(pojo.getId());
	
	
	}
}
