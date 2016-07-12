package me.dabpessoa.stringout.readers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
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

	private String toString(byte[] bytes) {
		return new String(bytes, Charset.forName(getEncoding()));
	}

	private InputStream findInputStreamClassPathFile() throws IOException {
		return this.getClass().getClassLoader().getResourceAsStream(getFilePath());
	}

	private byte[] findBytesClassPathFile() throws IOException {
		InputStream inputStream = findInputStreamClassPathFile();
		if (inputStream == null) throw new RuntimeException("Não foi possível localizar o arquivo: "+getFilePath());
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
