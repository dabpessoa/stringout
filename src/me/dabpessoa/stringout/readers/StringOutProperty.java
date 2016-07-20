package me.dabpessoa.stringout.readers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import me.dabpessoa.stringout.AbstractStringOut;
import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.service.ExpressionTranslator;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class StringOutProperty extends AbstractStringOut {

	private Properties properties;
	
	@Override
	public String find(String key) {
		try {
			return getProperties().getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		} return null;
	}

	@Override
	public String find(String key, Map<String, String> replacements) {
		String value = find(key);
		return ExpressionTranslator.process(value, replacements);
	}

	@Override
	public StringOutType getType() {
		return StringOutType.PROPERTY;
	}

	@Override
	public void load() throws IOException {
		properties = new Properties();
		InputStream inputStream = findInputStreamClassPathFile();
		if (inputStream == null) throw new FileNotFoundException(getFilePath());
		properties.load(inputStream);
	}
	
	public Properties getProperties() throws IOException {
		if (properties == null) load();
		return properties;
	}

}
