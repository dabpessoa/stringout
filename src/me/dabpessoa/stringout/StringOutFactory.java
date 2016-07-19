package me.dabpessoa.stringout;

import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.readers.StringOutJSON;
import me.dabpessoa.stringout.readers.StringOutMemory;
import me.dabpessoa.stringout.readers.StringOutProperty;
import me.dabpessoa.stringout.readers.StringOutXML;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class StringOutFactory {

	private StringOutFactory() {}
	
	public static StringOut create(StringOutType type) {
		switch (type) {
			case JSON: {
				return createStringOutJSON();
			}
			case XML: {
				return createStringOutXML();
			}
			case PROPERTY: {
				return createStringOutPROPERTY();
			}
			case MEMORY: {
				return createStringOutMEMORY();
			}
			default: {
				throw new RuntimeException("Invalid StringOut type: "+type);
			}
		}
	}
	
	public static StringOut createStringOutJSON() {
		return new StringOutJSON();
	}
	
	public static StringOut createStringOutXML() {
		return new StringOutXML();
	}
	
	public static StringOut createStringOutPROPERTY() {
		return new StringOutProperty();
	}
	
	public static StringOut createStringOutMEMORY() {
		return new StringOutMemory();
	}
	
}
