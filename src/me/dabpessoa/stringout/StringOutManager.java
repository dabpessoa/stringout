package me.dabpessoa.stringout;

import me.dabpessoa.stringout.enums.StringOutType;

public class StringOutManager {

	private static StringOut instance;
	
	public static StringOut getInstance(StringOutType type) {
		if (instance == null || !instance.getType().equals(type)) {
			instance = StringOutFactory.create(type);
		}
		return instance;
	}
	
}
