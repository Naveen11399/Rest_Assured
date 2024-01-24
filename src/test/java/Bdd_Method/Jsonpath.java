package Bdd_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class Jsonpath {

	@Test
	public void readingJsonFile() throws IOException {

		File jsonFile = new File("src/test/resources/sampleJsonPathFile.json");

		List<Object> gettingID = JsonPath.read(jsonFile, "$.topping[*].id");

		for (Object ID : gettingID) {
			System.out.println(ID);

		}

	}

	@Test
	public void parsingOneTime() throws IOException {

		InputStream jsonFile = new FileInputStream("src/test/resources/sampleJsonPathFile.json");

		Object parsedFile = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.readAllBytes());

		List<Object> gettingID = JsonPath.read(parsedFile, "$.topping[*].id");

		List<Object> gettingIType = JsonPath.read(parsedFile, "$.topping[*].type");

		for (Object ID : gettingID) {
			System.out.println(ID);

		}

		for (Object typeList : gettingIType) {
			System.out.println(typeList);

		}

		System.out.println("naveenuuu");
	}

	@Test
	public void fluentAPI() throws IOException {
		File jsonFile = new File("src/test/resources/sampleJsonPathFile.json");

		DocumentContext Context = JsonPath.parse(jsonFile);

		List<Object> id = Context.read("$.topping[*].id");

		for (Object idList : id) {
			System.out.println(idList);

		}

		Configuration config = Configuration.defaultConfiguration();
		List<Object> type = JsonPath.using(config).parse(jsonFile).read("$.topping[*].type");

		for (Object typeList : type) {
			System.out.println(typeList);

		}

	}

}
