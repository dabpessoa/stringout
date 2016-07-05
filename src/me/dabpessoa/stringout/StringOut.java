package me.dabpessoa.stringout;

import java.util.Map;

import me.dabpessoa.stringout.enums.StringOutType;

/**
 * 
 * @author diego.pessoa
 * @since 28/06/2016
 *
 */
public interface StringOut {

	public static final String FILE_NAME_DEFAULT = "stringout.json";
	public static final String CHARACTER_ENCODING_DEFAULT = "UTF-8";
	
	/**
	 * 
	 * @param key
	 * @return String value of the file whithout replacements for parameters.
	 */
	String find(String key) throws Throwable;
	
	/**
	 * 
	 * @param key
	 * @param replacements
	 * @return String value with the replacements done.
	 */
	String find(String key, Map<String, String> replacements) throws Throwable;
	
	/**
	 * 
	 * @return The type/format of the String file.
	 */
	StringOutType getType();
	
}
