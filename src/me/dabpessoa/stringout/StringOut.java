package me.dabpessoa.stringout;

import java.util.List;
import java.util.Map;

public interface StringOut {

	public static final String FILE_NAME_DEFAULT = "stringout.json";
	public static final String CHARACTER_ENCODING_DEFAULT = "UTF-8";
	public static final String NAMED_PARAM_REGEX = ":\\w+";
	
	/**
	 * 
	 * @param key
	 * @return String value of the file whithout replacements for parameters.
	 */
	String find(String key);
	
	/**
	 * 
	 * @param key
	 * @param replacements
	 * @return String value with the replacements done.
	 */
	String find(String key, Map<String, Object> replacements);
	
	/**
	 * 
	 * @param key
	 * @return List of params of the String selected by the key param.
	 */
	List<String> findParams(String key);
	
	/**
	 * 
	 * @return The type/format of the String file.
	 */
	StringOutType getType();
	
}
