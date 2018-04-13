package me.dabpessoa.stringout;

import me.dabpessoa.stringout.enums.StringOutType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public interface StringOut {

	public static final String FILE_NAME_DEFAULT = "stringout";
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
	 * Método para retornar a lista de todos os itens.
	 * @return
	 * @throws Throwable
	 */
	List<String> getAllValues() throws Throwable;

	/**
	 *
	 * @return
	 * @throws Throwable
	 */
	List<String> getAllKeys() throws Throwable;

	Map<String, String> getMapKeyValue() throws Throwable;
	
	/**
	 * 
	 * @return The type/format of the String file.
	 */
	StringOutType getType();
	
	void load() throws IOException;
	
	/**
	 * 
	 * @param path
	 */
	void setFilePath(String path);
	
	/**
	 * 
	 * @param encoding
	 */
	void setEncoding(String encoding);
	
}
