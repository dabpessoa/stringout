package me.dabpessoa.stringout.readers;

import java.util.List;
import java.util.Map;

import me.dabpessoa.stringout.StringOut;
import me.dabpessoa.stringout.enums.StringOutType;

public class StringOutProperty implements StringOut {

	@Override
	public String find(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String find(String key, Map<String, Object> replacements) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findParams(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringOutType getType() {
		return StringOutType.PROPERTY;
	}

}
