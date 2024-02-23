package deserialiazeAnnotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonIncludeSerialiazer {
	
	@Test
	public void JsonIgnoreAndInclude() throws JsonProcessingException {

		jsonIncludePojo pojo = new jsonIncludePojo();
		pojo.setName(null);
		pojo.setEmail("nk@cc.cc");
		pojo.setJob("Test Automation");
		pojo.setSkill(null);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(json);

	}
}
