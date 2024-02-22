package jacksonAnnotations;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class jsonSerializationAnnotationSerializer {

	@Test
	public void jsonSerializer() throws JsonProcessingException {
		jsonserializerPojo pojo = new jsonserializerPojo();
		pojo.setName("Naveenuuu");
		pojo.setPlace("PLK");
		pojo.setHobby(("Bike Ride,Music"));

		LifeStyle lifeStyle = new LifeStyle();
		lifeStyle.setMobile("Redmi note 13 pro plus");
		lifeStyle.setBike("Yamaha MT-15");
		lifeStyle.setCar("Mahindra Thar");
		pojo.setLifestyle(lifeStyle);

		ObjectMapper mapper = new ObjectMapper();

//		SimpleModule simpleModule = new SimpleModule();
//		simpleModule.addSerializer(jsonserializerPojo.class, new customSerializer());
//		mapper.registerModule(simpleModule);

		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(JSON);

	}
}
