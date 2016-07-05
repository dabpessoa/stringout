package me.dabpessoa.stringout.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import me.dabpessoa.stringout.StringOutManager;
import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.service.ExpressionTranslator;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Run run = new Run();
		
		String jsonTeste = run.fileJSONTeste();
		String translatorTeste = run.translatorTeste();
		
		System.out.println(jsonTeste);
		System.out.println();
		System.out.println(translatorTeste);
		
	}
	
	public String fileJSONTeste() {
		try {
			
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("replace", "gaiata");
			
			String value = StringOutManager.getInstance(StringOutType.JSON).find("example", replacements);
			
			return value;
			
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String translatorTeste() {
		
			
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("texto1", "gaiata");
		replacements.put("texto2", "sabida");
			
		String string = "era uma vez  <| :texto1 != null | inserindo uma :texto1 |>  final do teste <| :texto2 != null | novamente outra :texto2 |> no texto";
		
		String result = ExpressionTranslator.process(string, replacements);
		
		return result;
			
		
		
	}
	
}
