package Deserialization;

import java.util.List;

public class pojoClsMethod {

	private static String name;
	private String email;
	private List skills;
	
	private List message;

	public   String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List getSkills() {
		return skills;
	}

	public void setSkills(List skills) {
		this.skills = skills;
	}

	public List getMessage() {
		return message;
	}

	public void setMessage(List message) {
		this.message = message;
	}
}
