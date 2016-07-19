package me.dabpessoa.stringout.enums;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public enum ParamReplacementType {

	NAMED(":", ":\\w+"),
	ORDINAL("?", "");
	
	private String coringa;
	private String regex;
	
	private ParamReplacementType(String coringa, String regex) {
		this.coringa = coringa;
		this.regex = regex;
	}
	
	public String getCoringa() {
		return coringa;
	}
	
	public String getRegex() {
		return regex;
	}
	
}
