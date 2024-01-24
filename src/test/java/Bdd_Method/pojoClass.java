package Bdd_Method;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class pojoClass {

	public static void main(String[] args) throws JsonProcessingException {
		
		
		
		pojclassObj pojclassObj=new pojclassObj();
		
		pojclassObj.setEmail("naveen");
		pojclassObj.setName("nk");
		pojclassObj.setSkills(Arrays.asList("joker","hero"));
		
		System.out.println(pojclassObj.getEmail());
		System.out.println(pojclassObj.getName());
		System.out.println(pojclassObj.getSkills());
		
		ObjectMapper om=new ObjectMapper();
		String jsonFile=om.writerWithDefaultPrettyPrinter().writeValueAsString(pojclassObj);
		System.out.println(jsonFile);

	}

}
