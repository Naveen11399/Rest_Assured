package deserialiazeAnnotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class jsonAnySetterPojo {

	private Map<String, Object> contact = new HashMap<String, Object>();

	public Map<String, Object> getContact() {
		return contact;
	}

	@JsonAnySetter
	public void setContact(String Key, Object Value) {
		contact.put(Key, Value);
	}

}
