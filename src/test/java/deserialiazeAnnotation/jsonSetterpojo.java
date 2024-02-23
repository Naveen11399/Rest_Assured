package deserialiazeAnnotation;

import com.fasterxml.jackson.annotation.JsonSetter;

public class jsonSetterpojo {
	
	private int id;

	private String name;

	private String character;

	
	public int getId() {
		return id;
	}

	@JsonSetter(value = "broken")
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

	public void setCharacter(String character) {
		this.character = character;
	}

}
