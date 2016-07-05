package me.dabpessoa.stringout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git

<<<<<<< HEAD
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

=======
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
import me.dabpessoa.stringout.enums.ParamReplacementType;
import me.dabpessoa.stringout.util.RegexUtils;

public class ExpressionTranslator {

	private static final String EXPRESSION_REGEX = "(?s)(<\\|)((.*?))(\\|)(.*?)(\\|>)";
	
	public static String process(String value, Map<String, String> replacements) {
<<<<<<< HEAD
		String newValue = value;
=======
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
		
<<<<<<< HEAD
		newValue = doExpressionReplacements(newValue, replacements);
		newValue = doParamReplacements(newValue, replacements);

		return newValue;
=======
		String newValue = doParamReplacements(value, replacements);
		
		List<String> expressions = RegexUtils.findMatches(EXPRESSION_REGEX, newValue);
		
		String result = doExpressionReplacements(newValue, expressions);

		return result;
		
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
	}
	
<<<<<<< HEAD
	private static String[] proccessExpressions(List<String> matches, Map<String, String> replacements) {
=======
	private static String[] proccessExpressions(List<String> matches) {
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
		
		List<String> results = new ArrayList<String>();
		for (String match : matches) {
			String expression = match.substring(match.indexOf("<|")+2, match.indexOf("|", 2));
			String value = match.substring(match.indexOf("|", 2)+1, match.indexOf("|>"));
			
			if (expression != null) expression = expression.trim();
			if (value != null) value = value.trim();
			
<<<<<<< HEAD
			boolean booleanExpressionResult = translateBooleanExpression(expression, replacements);
=======
			boolean booleanExpressionResult = translateBooleanExpression(expression);
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
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
<<<<<<< HEAD
=======
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
		
>>>>>>> branch 'master' of https://github.com/dabpessoa/stringout.git
	}
	
	private static String doExpressionReplacements(String value, Map<String, String> replacements) {
		List<String> expressions = RegexUtils.findMatches(EXPRESSION_REGEX, value);
		String[] expressionsResults = proccessExpressions(expressions, replacements);
		return RegexUtils.replaceMatches(EXPRESSION_REGEX, value, expressionsResults);
	}
	
	private static List<String> findParamsFromValue(String value) {
		return RegexUtils.findMatches(ParamReplacementType.NAMED.getRegex(), value);
	}
	
	private static boolean translateBooleanExpression(String expression, Map<String, String> replacements) {
		
		boolean result = false;
		
		expression = expression.replace((CharSequence)":", (CharSequence)"");
		
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("JavaScript");
		
		Set<String> keys = replacements.keySet();
		for (String key : keys) {
			engine.put(key, replacements.get(key));
		}
		
		try {
			Object evalResult = engine.eval(expression);
			if (evalResult != null) {
				result = Boolean.parseBoolean(evalResult.toString());
			}
		} catch (ScriptException e) {
			if (e.getMessage() != null && e.getMessage().indexOf("ReferenceError") != -1) {
				result = false;
			} else {
				throw new RuntimeException("Erro ao tentar interpretar código javascript. Mensagem: "+e.getMessage(), e);
			}
		} 
		
		return result;
		
	}
	
}
