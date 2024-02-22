package jacksonAnnotations;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;



//Json serialize and json root value method


@JsonRootName(value ="Introduction")
@JsonSerialize(using = customSerializer.class)
public class jsonserializerPojo {

	private LifeStyle lifestyle;
	
	private String name;
	
	private String Place;
	
	private String  hobby; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	
	LifeStyle lifeStyle =new LifeStyle();

	public LifeStyle getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(LifeStyle lifestyle) {
		this.lifestyle = lifestyle;
	}
	
	
	
}
