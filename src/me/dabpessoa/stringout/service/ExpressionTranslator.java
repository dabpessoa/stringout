package me.dabpessoa.stringout.service;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import me.dabpessoa.stringout.util.RegexUtils;

public class ExpressionTranslator {

	private static final String EXPRESSION_REGEX = "(?s)(<\\|)((.*?))(\\|)(.*?)(\\|>)";
	
	public String processString(String string) {
		
		List<String> matches = RegexUtils.findMatches(EXPRESSION_REGEX, string);
		
		String[] processResults = proccessMatches(matches);
		
		String newString = RegexUtils.replaceMatches(EXPRESSION_REGEX, string, processResults);
		
		return newString;
		
	}
	
	private String[] proccessMatches(List<String> matches) {
		
		List<String> results = new ArrayList<String>();
		for (String match : matches) {
			String expression = match.substring(match.indexOf("<|")+2, match.indexOf("|", 2));
			String value = match.substring(match.indexOf("|", 2)+1, match.indexOf("|>"));
			
			if (expression != null) expression = expression.trim();
			if (value != null) value = value.trim();
			
			results.add(value);
		}
		
		return results.toArray(new String[results.size()]);
	}
	
	public boolean translateBooleanExpression(String expression) {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("JavaScript");
		return false;
		// TODO FALTA TERMINAR DE IMPLEMENTAR
	}
	
	public static void main(String[] args) {
		
	}
	
}
