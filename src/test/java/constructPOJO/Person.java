package constructPOJO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

	private String name;

	private int age;

	private String email;
	
	private Address address;
	
	  private List<phoneNumber> phoneNumberu;

}
