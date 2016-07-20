package me.dabpessoa.stringout.enums;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public enum StringOutType {

	JSON(".json"),
	XML(".xml"),
	PROPERTY(".properties"),
	MEMORY(null);
	
	private String extension;
	
	private StringOutType(String extension) {
		this.extension = extension;
	}
	
	public String extension() {
		return extension;
	}
	
}
