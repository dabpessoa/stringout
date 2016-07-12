package me.dabpessoa.stringout.readers;

import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.dabpessoa.stringout.AbstractStringOut;
import me.dabpessoa.stringout.entity.JSONEntity;
import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.service.ExpressionTranslator;

public class StringOutJSON extends AbstractStringOut {
	
	@Override
	public String find(String key, Map<String, String> replacements) {
		String value = find(key);
		return ExpressionTranslator.process(value, replacements);
	}
	
	@Override
	public String find(String key) {
		JSONEntity jsonEntity = findJSONEntityById(key);
		String value = jsonEntity.getValue();
		return value;
	}
	
	@Override
	public StringOutType getType() {
		return StringOutType.JSON;
	}
	
	private JSONEntity findJSONEntityById(String id) {
		try {
			JSONEntity[] jsonEntities = toJSONEntities();
			if (jsonEntities != null) {
				for (JSONEntity jsonEntity : jsonEntities) {
					if (jsonEntity.getId() != null && jsonEntity.getId().trim().equals(id)) {
						return jsonEntity;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private JSONEntity[] toJSONEntities() throws IOException {
		byte[] bytes = findBytesClassPathFile();
		String fileString = toString(bytes);
		JSONEntity[] jsonEntities = toJSONEntities(fileString);
		return jsonEntities;
	}

	private JSONEntity[] toJSONEntities(String fileString) {
		Gson gson = new GsonBuilder().create();
		JSONEntity[] jsonEntity = gson.fromJson(fileString, JSONEntity[].class);
		return jsonEntity;
	}

}
