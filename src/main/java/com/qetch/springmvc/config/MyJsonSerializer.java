package com.qetch.springmvc.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyJsonSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString("");
//		gen.writeObject(new JsonNullDef());
	}
}

class JsonNullDef {
	private List<String> def = new ArrayList<>();
	public List<String> getDef() {
		return def;
	}
	public void setDef(List<String> def) {
		this.def = def;
	}
}
