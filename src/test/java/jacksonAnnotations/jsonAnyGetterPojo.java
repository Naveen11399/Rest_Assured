package jacksonAnnotations;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class jsonAnyGetterPojo {
	private Map<String, Object> bioData;

	@JsonAnyGetter
	public Map<String, Object> getBioData() {
		return bioData;
	}

	public void setBioData(Map<String, Object> bioData) {
		this.bioData = bioData;
	}
}
