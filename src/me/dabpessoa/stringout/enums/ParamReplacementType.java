package me.dabpessoa.stringout.enums;

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
