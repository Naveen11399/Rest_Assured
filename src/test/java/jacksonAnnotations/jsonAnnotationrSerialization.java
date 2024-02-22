package jacksonAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonAnnotationrSerialization {

	

	@Test
	public void anygetter() throws JsonProcessingException {
		jsonAnyGetterPojo jsonPojo = new jsonAnyGetterPojo();
		Map<String, Object> mapValues = new HashMap<String, Object>();
		mapValues.put("name", "naveenuu");
		mapValues.put("type", "jokeruu");
		mapValues.put("Car", "Thar");
		mapValues.put("Skills", Arrays.asList("adithangi", "jokeru"));

		jsonPojo.setBioData(mapValues);

		ObjectMapper objectMap = new ObjectMapper();
		String json = objectMap.writerWithDefaultPrettyPrinter().writeValueAsString(mapValues);
		System.out.println(json);

	}
	
	@Test
	public void jsonGetter() throws JsonProcessingException {
		
		jsonGetterPojo getter=new jsonGetterPojo();
		getter.setId(7);
		getter.setName("naveenuuu");
		getter.setCharacter("Paithiyam");
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getter);
		System.out.println(json);
	}
	
}
