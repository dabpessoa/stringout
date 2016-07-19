package me.dabpessoa.stringout.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.dabpessoa.stringout.StringOut;
import me.dabpessoa.stringout.StringOutManager;
import me.dabpessoa.stringout.enums.StringOutType;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class Run {

	public static void main(String[] args) throws IOException {
		
		Run run = new Run();
		StringOut stringout = StringOutManager.getInstance(StringOutType.JSON);
		
		// Testando exemplos JSON
		String exemplo1 = run.example1(stringout);
		String exemplo2 = run.example2(stringout);
		String exemplo3 = run.example3(stringout);
		String exemplo4 = run.example4(stringout);
		String exemplo5 = run.example5(stringout);
		String exemplo6 = run.example6(stringout);
		
		System.out.println("Resultado exemplo 1: "+exemplo1);
		System.out.println("Resultado exemplo 2: "+exemplo2);
		System.out.println("Resultado exemplo 3: "+exemplo3);
		System.out.println("Resultado exemplo 4: "+exemplo4);
		System.out.println("Resultado exemplo 5: "+exemplo5);
		System.out.println("Resultado exemplo 6: "+exemplo6);
		
	}
	
	public String example1(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("adjetivo", "magra");
			replacements.put("outroAdjetivo", "gordo");
			
			String string = stringout.find("example1", replacements);
			
			return string;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example2(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("autor", "Didi Mocó Sonrrizal Colesterol Novalgina Mofumo");
			
			String value = stringout.find("example2", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example3(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("comoAmanheceu", "chovendo");
			
			String value = stringout.find("example3", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example4(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("nome", "Diego Pessoa");
			
			String value = stringout.find("example4", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example5(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("adjetivo", "alta");
			replacements.put("outroAdjetivo", "doido");
			
			stringout.setFilePath("queries.json");
			stringout.load();
			
			String string = stringout.find("example1", replacements);
			
			return string;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example6(StringOut stringout) {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("param1", "Goku");
			replacements.put("param2", "Vegeta");
			
			stringout.setFilePath("queries.json");
			stringout.setEncoding("UTF-8");
			stringout.load();
			
			String string = stringout.find("example2", replacements);
			
			return string;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
