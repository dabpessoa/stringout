package me.dabpessoa.stringout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StringOutJSON implements StringOut {

	@Override
	public String find(String key, Map<String, Object> replacements) {
		
		String value = find(key);
        List<String> valueParams = findParamsFromValue(value);
        
        for (String valueParam : valueParams) {
        	Object replacement = replacements.get(valueParam);
			value = value.replaceAll(":"+valueParam, replacement.toString());
		}
        
        return value;
	}
	
	@Override
	public List<String> findParams(String key) {
		String value = find(key);
		return findParamsFromValue(value);
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
	
	private static List<String> findParamsFromValue(String value) {
		Pattern pattern = Pattern.compile(NAMED_PARAM_REGEX);  
        Matcher matcher = pattern.matcher(value);  
        
        int count = 0;
        Set<String> valueParams = new HashSet<String>();
        while (matcher.find()) {
        	String valueParam = matcher.group(count++);
        	valueParam = valueParam.substring(1);
        	valueParams.add(valueParam);
        }
        
        return new ArrayList<String>(valueParams); 
	}
	
	private static JSONEntity findJSONEntityById(String id) {
		StringOutJSON sh = new StringOutJSON();
		try {
			JSONEntity[] jsonEntities = sh.toJSONEntities();
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

	private String toString(byte[] bytes) {
		return new String(bytes, Charset.forName(CHARACTER_ENCODING_DEFAULT));
	}

	private InputStream findInputStreamClassPathFile() throws IOException {
		return this.getClass().getClassLoader().getResourceAsStream(FILE_NAME_DEFAULT);
	}

	private byte[] findBytesClassPathFile() throws IOException {
		InputStream inputStream = findInputStreamClassPathFile();
		return getBytes(inputStream);
	}

	private static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}

}
