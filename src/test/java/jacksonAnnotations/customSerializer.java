package jacksonAnnotations;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class customSerializer extends StdSerializer<jsonserializerPojo> {

	public customSerializer(Class<jsonserializerPojo> t) {
		super(t);

	}
	
	 public customSerializer() {
		 
		 this(null);
		 
	 }
	

	@Override
	public void serialize(jsonserializerPojo value, JsonGenerator gen, SerializerProvider provider) throws IOException {

		gen.writeStartObject();
		gen.writeStringField("name", value.getName());
		gen.writeStringField("place", value.getPlace());
		gen.writeStringField("Car", value.getLifestyle().getCar());
		gen.writeEndObject();

	}

}
