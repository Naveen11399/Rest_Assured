package deserialiazeAnnotation;

import com.fasterxml.jackson.annotation.JsonAlias;


public class jsonAliasPojo {

	@JsonAlias({ "broken", "JD" })
	private String id;

	private String name;
	
	private String character;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
