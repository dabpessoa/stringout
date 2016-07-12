package me.dabpessoa.stringout.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.dabpessoa.stringout.StringOutManager;
import me.dabpessoa.stringout.enums.StringOutType;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Run run = new Run();
		
		// Testando exemplos JSON
		String exemplo1 = run.example1();
		String exemplo2 = run.example2();
		String exemplo3 = run.example3();
		String exemplo4 = run.example4();
		
		System.out.println("Resultado exemplo 1: "+exemplo1);
		System.out.println("Resultado exemplo 2: "+exemplo2);
		System.out.println("Resultado exemplo 3: "+exemplo3);
		System.out.println("Resultado exemplo 4: "+exemplo4);
		
	}
	
	public String example1() {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("adjetivo", "magra");
			replacements.put("outroAdjetivo", "gordo");
			
//			String string = StringOutManager.getInstance(StringOutType.JSON, "stringout.json").find("example1", replacements);
			String string = StringOutManager.getInstance(StringOutType.JSON).find("example1", replacements);
			
			return string;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example2() {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("autor", "Didi Moc� Sonrrizal Colesterol Novalgina Mofumo");
			
			String value = StringOutManager.getInstance(StringOutType.JSON).find("example2", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example3() {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("comoAmanheceu", "chovendo");
			
			String value = StringOutManager.getInstance(StringOutType.JSON).find("example3", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String example4() {
		try {
		
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("nome", "Diego Pessoa");
			
			String value = StringOutManager.getInstance(StringOutType.JSON).find("example4", replacements);
			
			return value;
		
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
