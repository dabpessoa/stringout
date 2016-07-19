package me.dabpessoa.stringout;

import me.dabpessoa.stringout.enums.StringOutType;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class StringOutManager {

	public static StringOut getInstance(StringOutType type) {
		return StringOutFactory.create(type);
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
