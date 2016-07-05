package me.dabpessoa.stringout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import me.dabpessoa.stringout.enums.ParamReplacementType;
import me.dabpessoa.stringout.util.RegexUtils;

public class ExpressionTranslator {

	private static final String EXPRESSION_REGEX = "(?s)(<\\|)((.*?))(\\|)(.*?)(\\|>)";
	
	public static String process(String value, Map<String, String> replacements) {
		
		String newValue = doParamReplacements(value, replacements);
		
		List<String> expressions = RegexUtils.findMatches(EXPRESSION_REGEX, newValue);
		
		String result = doExpressionReplacements(newValue, expressions);

		return result;
		
	}
	
	private static String[] proccessExpressions(List<String> matches) {
		
		List<String> results = new ArrayList<String>();
		for (String match : matches) {
			String expression = match.substring(match.indexOf("<|")+2, match.indexOf("|", 2));
			String value = match.substring(match.indexOf("|", 2)+1, match.indexOf("|>"));
			
			if (expression != null) expression = expression.trim();
			if (value != null) value = value.trim();
			
			boolean booleanExpressionResult = translateBooleanExpression(expression);
			if (!booleanExpressionResult) value = "";
			
			results.add(value);
		}
		
		return results.toArray(new String[results.size()]);
	}
	
	private static String doParamReplacements(String value, Map<String, String> replacements) {
		if (replacements == null) return value;
		String newValue = value;
		List<String> params = findParamsFromValue(value);
		for (String param : params) {
			param = param.substring(1);
			Object replacement = replacements.get(param);
			if (replacement != null) {
				newValue = newValue.replace((CharSequence) ":" + param, (CharSequence) replacement.toString());
			}
		}
		return newValue;
	}
	
	private static String doExpressionReplacements(String value, List<String> matches) {
		String[] expressionsResults = proccessExpressions(matches);
		return RegexUtils.replaceMatches(EXPRESSION_REGEX, value, expressionsResults);
	}
	
	private static List<String> findParamsFromValue(String value) {
		return RegexUtils.findMatches(ParamReplacementType.NAMED.getRegex(), value);
	}
	
	private static boolean translateBooleanExpression(String expression) {
			
		// TODO FIXME Falta colocar esse código para funcionar corretamente.
		
//		boolean result = false;
//		ScriptEngineManager sem = new ScriptEngineManager();
//		ScriptEngine engine = sem.getEngineByName("JavaScript");
//		try {
//			Object evalResult = engine.eval(expression);
//			if (evalResult != null) {
//				result = Boolean.parseBoolean(evalResult.toString());
//			}
//		} catch (ScriptException e) {
//			e.printStackTrace();
//		} 
//		
//		return result;
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
