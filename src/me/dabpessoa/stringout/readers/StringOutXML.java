package me.dabpessoa.stringout.readers;

import me.dabpessoa.stringout.AbstractStringOut;
import me.dabpessoa.stringout.enums.StringOutType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class StringOutXML extends AbstractStringOut {

	@Override
	public String find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String find(String key, Map<String, String> replacements) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllValues() throws Throwable {
		return null;
	}

	@Override
	public List<String> getAllKeys() throws Throwable {
		return null;
	}

	@Override
	public Map<String, String> getMapKeyValue() throws Throwable {
		return null;
	}

	@Override
	public StringOutType getType() {
		return StringOutType.XML;
	}

	@Override
	public void load() throws IOException {
		// TODO Auto-generated method stub
	}

}
