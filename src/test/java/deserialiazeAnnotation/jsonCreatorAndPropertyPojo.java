package deserialiazeAnnotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class jsonCreatorAndPropertyPojo {

	private int id;

	private String name;

	private String character;
	
	@JsonCreator
	public jsonCreatorAndPropertyPojo(
			@JsonProperty("broken")
			int id,
			@JsonProperty("name")
			String name,
			@JsonProperty("character")
			String character) {
		
	
		this.id=id;
		this.name=name;
		this.character=character;
		
	}

	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getCharacter() {
		return character;
	}

}
