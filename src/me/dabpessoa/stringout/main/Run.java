package me.dabpessoa.stringout.main;

import java.io.IOException;

import me.dabpessoa.stringout.service.ExpressionTranslator;

public class Run {

	public static void main(String[] args) throws IOException {
		
//		Map<String, Object> replacements = new HashMap<String, Object>();
//		replacements.put("replace", "gaiata");
//		
//		String value = StringOutManager.getInstance(StringOutType.JSON).find("example", replacements);
//		
//		System.out.println(value);
		new Run().teste();
		
	}
	
	public void teste() {
		
		ExpressionTranslator et = new ExpressionTranslator();
		
		String string = "era uma vez  <| texto1 | value1 |>  final do teste <| texto1 | value2 |> djaklfjdlaje";
		
		String newString = et.processString(string);
		
		System.out.println(newString);
		
	}
	
}
