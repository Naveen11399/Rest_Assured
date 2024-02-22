package jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

//Json Property order and getter Annotation 
//1.@JsonRawValue 
//2.@JsonPropertyOrder(alphabetic = true)
// 3.@JsonGetter(value = "broken") 
//4.@JsonValue

//@JsonPropertyOrder(alphabetic = true)
//@JsonPropertyOrder({"character","name","id"})
public class jsonGetterPojo {

	private int id;

	private String name;

	private String character;

	@JsonGetter(value = "broken")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	//@JsonRawValue
	public void setCharacter(String character) {
		this.character = character;
	}

	//@JsonValue
	public  String valueExample() {
		
		return this.character;
	}
}
