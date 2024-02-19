package constructPOJO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class serializer {

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void serailizer() throws StreamWriteException, DatabindException, IOException {

		Person person = new Person();

		person.setName("naveenuu");
		person.setAge(25);
		person.setEmail("nk@gmail.com");

		Address address = new Address();

		address.setStreet("north street");
		address.setCity("plk");
		address.setState("TN");
		address.setZipcode(608701);
		person.setAddress(address);

		List<phoneNumber> phoneNumberu = new ArrayList<>();

		phoneNumber ph = new phoneNumber();
		ph.setType("Home");
		ph.setNumber(2343);

		phoneNumberu.add(ph);

		phoneNumber ph1 = new phoneNumber();
		ph1.setType("Work");
		ph1.setNumber(777);

		phoneNumberu.add(ph1);

		person.setPhoneNumberu(phoneNumberu);

		ObjectMapper mapper = new ObjectMapper();
		File file = new File("pojoCreate.json");

		mapper.writerWithDefaultPrettyPrinter().writeValue(file, person);

		Person des = mapper.readValue(file, Person.class);

		System.out.println(des.getEmail());
		System.out.println(des.getName());
	}

	@Test
	public void deserialiazation() throws IOException {
		File file = new File("pojoCreate.json");
		Person person = mapper.readValue(file, Person.class);

		System.out.println(person.getName());
		System.out.println(person.getEmail());
		System.out.println(person.getAge());
		System.out.println(person.getAddress().getStreet() + person.getAddress().getCity() + person.getAddress().getState()
				+ person.getAddress().getZipcode());


		for (phoneNumber ph : person.getPhoneNumberu()) {
			System.out.println(ph.getType() + ph.getNumber());

		}
	}
}
