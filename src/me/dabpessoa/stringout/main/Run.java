package me.dabpessoa.stringout.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.dabpessoa.stringout.StringOutManager;
import me.dabpessoa.stringout.enums.StringOutType;
import me.dabpessoa.stringout.util.RegexUtils;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Map<String, Object> replacements = new HashMap<String, Object>();
		replacements.put("replace", "gaiata");
		
		String value = StringOutManager.getInstance(StringOutType.JSON).find("example", replacements);
		
		System.out.println(value);
//		new Run().teste();
		
	}
	
//	public void teste() {
//		
//		String regex = "(?s)(<\\|)((.*?))(\\|)(.*?)(\\|>)";
//		String teste = "era uma vez  <| texto1 | texto2 |>  final do teste <| texto1 | texto2 |> djaklfjdlaje";
//		List<String> matches = RegexUtils.findMatches(regex, teste);
//		
//		for (String match : matches) {
//			System.out.println("=> "+match);
//		}
//		
//		String[] processResults = proccessMatches(matches);
//		
//		String newString = RegexUtils.removeMatches(regex, teste);
////		String newString = RegexUtils.replaceMatches(regex, teste, "foi1", "foi2");
//		System.out.println("(*) "+newString);
//				
//		
////		(?s)(<\|)((.*?))(\|)(.*?)(\|>)
//		
////		<| :replace != null |
////    		:replace
////    	|>
////	    	
////    	<| :replace == null |
////    		Dolly
////    	|>
//	}
//	
//	public String[] proccessMatches(List<String> matches) {
//		
//		
//		return null;
//	}
	
}
