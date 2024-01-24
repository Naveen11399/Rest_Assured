package Bdd_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONschemaValidationUsingNetworkn {

	@Test
	public void JSONschemaValidationNetworkn() throws IOException {
		ObjectMapper Mapper = new ObjectMapper();

		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);
		File inputFile = new File("src/test/resources/newPostFile.json");
		InputStream inputschema = new FileInputStream("src/test/resources/newSchema.json");

		JsonNode jsonNode = Mapper.readTree(inputFile);
		JsonSchema schema = factory.getSchema(inputschema);
		Set<ValidationMessage> result = schema.validate(jsonNode);

		if (result.isEmpty()) {
			System.out.println("No errors");
		} else {
			for (ValidationMessage Message : result) {
				System.out.println(Message);
			}
		}
	}

	@Test
	public void JSONschemaValidationHamcrest() throws IOException {
		File inputFile = new File("src/test/resources/newPostFile.json");
		String JSON = FileUtils.readFileToString(inputFile, "UTF-8");
		File inputschema = new File("src/test/resources/newSchema.json");

		MatcherAssert.assertThat(JSON, JsonSchemaValidator.matchesJsonSchema(inputschema));

	}

}
