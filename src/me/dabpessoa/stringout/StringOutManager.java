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
	
	public static StringOut getInstance(StringOutType type, String filePath) {
		StringOut so = getInstance(type);
		so.setFilePath(filePath);
		return so;
	}
	
	public static StringOut getInstanceWithEncoding(StringOutType type, String encoding) {
		StringOut so = getInstance(type);
		so.setEncoding(encoding);
		return so;
	}
	
	public static StringOut getInstance(StringOutType type, String filePath, String encoding) {
		StringOut so = getInstance(type);
		so.setFilePath(filePath);
		so.setEncoding(encoding);
		return so;
	}
	
}
