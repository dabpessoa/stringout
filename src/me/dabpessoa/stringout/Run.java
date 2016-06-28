package me.dabpessoa.stringout;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Map<String, Object> replacements = new HashMap<String, Object>();
		replacements.put("description", "funfou");
		
		String value = StringOutManager.getInstance(StringOutType.JSON).find("findAllModules", replacements);
		
		System.out.println("String encontrada e tratada: "+value);
		
	}
	
}
