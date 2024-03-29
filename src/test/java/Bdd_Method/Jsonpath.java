package Bdd_Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


import javax.annotation.meta.When;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.Predicate.PredicateContext;

import static com.jayway.jsonpath.Filter.*;
import static com.jayway.jsonpath.JsonPath.*;
import static com.jayway.jsonpath.Criteria.*;

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

	@Test
	public void knowWhatIsReturn() throws IOException {

		// Define Path---return single value based on the return ,we need to create a
		// variable like string ,int

		// IndefinePath--{..-deepscan,expressrion-[?@(exp)],[0,1],[*]}
		File jsonFile = new File("src/test/resources/sampleJsonPathFile.json");

		DocumentContext context = JsonPath.parse(jsonFile);

		String typeList = context.read("$.topping[0].type");

		System.out.println(typeList);

		List<Object> typeList1 = context.read("$.topping[*].type");

		for (Object type1 : typeList1) {
			System.out.println(type1);

		}

		// $..batter[?(@.id=='1001' || @.type=='Chocolate')]
	}

	@Test
	public void inlinePredicates() throws IOException {

		File jsonFile = new File("src/test/resources/sampleJsonPathFile.json");

		DocumentContext context = JsonPath.parse(jsonFile);

		List<Object> andLogic = context.read("$..batter[?(@.id=='1003' && @.type=='Blueberry')]");

		for (Object logic1 : andLogic) {
			System.out.println(logic1);

		}

		List<Object> orLogic = context.read("$..batter[?(@.id=='1001' || @.type=='Chocolate')]");

		for (Object logic2 : orLogic) {
			System.out.println(logic2);

		}

		List<Object> norLogic = context.read("$..batter[?(!(@.id=='1001' || @.type=='Chocolate'))]");

		for (Object logic3 : norLogic) {
			System.out.println(logic3);

		}

	}

	@Test
	public void FilterPredicates() throws IOException {
		
		File jsonFile = new File("src/test/resources/sampleJsonPathFile.json");
		 
	    Filter filter= Filter.filter(
		Criteria
		.where("id")
		.eq("1003")
		.and("type")
		.is("Blueberry")
		
			);
		
	    List<Object> type = JsonPath.parse(jsonFile).read("$..batter[?]",filter);
		
		System.out.println(type);
		
		Filter staticFilter=filter(
				where("id")
				.gt("1001")
				.and("type")
				.is("Devil's Food")
				);
		
		 List<Map<String,Object>> type1 = parse(jsonFile).read("$..batter[*]", staticFilter);
		 System.out.println(type1.get(2).get("type"));

	}
	
	@Test
	public void ownPredicates() throws IOException {
		File jsonFile = new File("src/test/resources/BooksJson.json");
		
		//Functional Expression 
		
		
		/*
		Predicate pd=new Predicate() {
			
			@Override
			public boolean apply(PredicateContext ctx) {
				boolean txt=ctx.item(Map.class).containsKey("ISBN");
				
				return txt;
			}*/
		
		//lambda expressions
		Predicate pd=ctx->ctx.item(Map.class).containsKey("ISBN");
		 List<Map<String,Object>> type1 = parse(jsonFile).read("$..Books[*].ISBN",pd );
		 System.out.println(type1);
			
		};
		
	@Test	
	public void configuration() throws IOException {
		
		File jsonFile = new File("src/test/resources/BooksJson.json");

		Configuration config = Configuration.defaultConfiguration();
		config.addOptions(Option.REQUIRE_PROPERTIES.SUPPRESS_EXCEPTIONS);
		config.addOptions(Option.REQUIRE_PROPERTIES.ALWAYS_RETURN_LIST);
		config.addOptions(Option.REQUIRE_PROPERTIES.DEFAULT_PATH_LEAF_TO_NULL);
    String res = JsonPath.using(config).parse(jsonFile).read("$.Books[*].ISBN");
		
		System.out.println(res);
		
	}
	
	

}
