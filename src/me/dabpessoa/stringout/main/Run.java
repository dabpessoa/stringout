package me.dabpessoa.stringout.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.dabpessoa.stringout.StringOutManager;
import me.dabpessoa.stringout.enums.StringOutType;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Map<String, Object> replacements = new HashMap<String, Object>();
		replacements.put("replace", "gaiata");
		
		String value = StringOutManager.getInstance(StringOutType.JSON).find("example", replacements);
		
		System.out.println(value);
		
	}
	
	public void teste() {
//		<| :replace != null |
//    		:replace
//    	|>
//	    	
//    	<| :replace == null |
//    		Dolly
//    	|>
	}
	
}
