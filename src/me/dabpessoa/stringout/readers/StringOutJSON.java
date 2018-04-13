package me.dabpessoa.stringout.readers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.dabpessoa.stringout.AbstractStringOut;
import me.dabpessoa.stringout.entity.JSONEntity;
import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.service.ExpressionTranslator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class StringOutJSON extends AbstractStringOut {
	
	private JSONEntity[] jsonEntities;
	
	@Override
	public String find(String key, Map<String, String> replacements) {
		String value = find(key);
		return ExpressionTranslator.process(value, replacements);
	}
	
	@Override
	public String find(String key) {
		JSONEntity jsonEntity = findJSONEntityById(key);
		if (jsonEntity == null) throw new RuntimeException("Nenhuma string encontrada com o id: "+key);
		String value = jsonEntity.getValue();
		return value;
	}

	@Override
	public List<String> getAllValues() throws Throwable {
		JSONEntity[] jsonEntities = toJSONEntities();
		List<String> values = new ArrayList<>();
		if (jsonEntities != null) {
			for (JSONEntity jsonEntity : jsonEntities) {
				if (jsonEntity.getValue() != null && !jsonEntity.getValue().isEmpty()) {
					values.add(jsonEntity.getValue());
				}
			}
		} return values;
	}

	@Override
	public List<String> getAllKeys() throws Throwable {
		JSONEntity[] jsonEntities = toJSONEntities();
		List<String> keys = new ArrayList<>();
		if (jsonEntities != null) {
			for (JSONEntity jsonEntity : jsonEntities) {
				if (jsonEntity.getId() != null && !jsonEntity.getId().isEmpty()) {
					keys.add(jsonEntity.getId());
				}
			}
		} return keys;
	}

	@Override
	public Map<String, String> getMapKeyValue() throws Throwable {
		JSONEntity[] jsonEntities = toJSONEntities();
		Map<String, String> mapKeyValue = new HashMap<>();
		if (jsonEntities != null) {
			for (JSONEntity jsonEntity : jsonEntities) {
				if (jsonEntity != null) {
					String key = jsonEntity.getId();
					String value = jsonEntity.getValue();
					if (key != null && !key.isEmpty() && value != null && !value.isEmpty()) {
						mapKeyValue.put(key, value);
					}
				}
			}
		} return mapKeyValue;
	}

	@Override
	public StringOutType getType() {
		return StringOutType.JSON;
	}
	
	@Override
	public void load() throws IOException {
		byte[] bytes = findBytesClassPathFile();
		String fileString = toString(bytes);
		jsonEntities = toJSONEntities(fileString);
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
		if (jsonEntities == null) {load();}
		return jsonEntities;
	}

	private JSONEntity[] toJSONEntities(String fileString) {
		Gson gson = new GsonBuilder().create();
		JSONEntity[] jsonEntity = gson.fromJson(fileString, JSONEntity[].class);
		return jsonEntity;
	}

}
