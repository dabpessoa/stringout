package me.dabpessoa.stringout;

public class StringOutFactory {

	private StringOutFactory() {}
	
	public static StringOut create(StringOutType type) {
		switch (type) {
			case JSON: {
				return createStringOutJSON();
			}
			default: {
				throw new RuntimeException("Invalid StringOut type: "+type);
			}
		}
	}
	
	public static StringOut createStringOutJSON() {
		return new StringOutJSON();
	}
	
}
