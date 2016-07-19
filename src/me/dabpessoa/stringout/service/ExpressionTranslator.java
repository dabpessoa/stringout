package me.dabpessoa.stringout.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import me.dabpessoa.stringout.enums.ParamReplacementType;
import me.dabpessoa.stringout.service.EvaluateExpression.ScriptTypes;
import me.dabpessoa.stringout.util.RegexUtils;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class ExpressionTranslator {

	public static final String EXPRESSION_TRANSLATOR_REGEX = "(?s)(<\\|(.*?)?\\|>)(.*?)?(<\\|\\|>)";
	public static final int EXPRESSION_GROUP_NUMBER = 2;
	public static final int VALUE_GROUP_NUMBER = 3;
	private static final ScriptTypes DEFAULT_SCRIPT_ENGINE_TYPE = ScriptTypes.JAVASCRIPT;
	
	private ExpressionTranslator() {}
	
	public enum EXPRESSION_SEPARATORS {
		LEFT("<\\|"), // <|
		RIGHT("\\|>"), // |>
		CLOSE("<\\|\\|>"); // <||>
		
		private String separatorObject;
		
		private EXPRESSION_SEPARATORS(String separatorObject) {
			this.separatorObject = separatorObject;
		}
		
		public String get() {
			return separatorObject;
		}
		
	};
	
	public static String process(String value, Map<String, String> replacements) {
		String newValue = value;

		newValue = doExpressionReplacements(newValue, replacements);
		newValue = doParamReplacements(newValue, replacements);

		return newValue;
	}
	
	private static String[] proccessExpressions(List<String> matches, Map<String, String> replacements) {
		List<String> results = new ArrayList<String>();
		for (String match : matches) {
			String expression = RegexUtils.findGroup(EXPRESSION_TRANSLATOR_REGEX, match, EXPRESSION_GROUP_NUMBER);
			String value = RegexUtils.findGroup(EXPRESSION_TRANSLATOR_REGEX, match, VALUE_GROUP_NUMBER);
			
			if (expression != null) expression = expression.trim();
			if (value != null) value = value.trim();

			boolean booleanExpressionResult = translateBooleanExpression(expression, replacements);

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
	
	private static String doExpressionReplacements(String value, Map<String, String> replacements) {
		List<String> expressions = RegexUtils.findMatches(EXPRESSION_TRANSLATOR_REGEX, value);
		String[] expressionsResults = proccessExpressions(expressions, replacements);
		return RegexUtils.replaceMatches(EXPRESSION_TRANSLATOR_REGEX, value, expressionsResults);
	}
	
	private static List<String> findParamsFromValue(String value) {
		return RegexUtils.findMatches(ParamReplacementType.NAMED.getRegex(), value);
	}
	
	private static boolean translateBooleanExpression(String expression, Map<String, String> replacements) {
		
		if (replacements == null) return false;
		
		boolean result = false;
		
		List<String> variables = findParamsFromValue(expression);
		expression = expression.replace((CharSequence)":", (CharSequence)"");
		
		ScriptEngine engine = EvaluateExpression.getScriptEngine(DEFAULT_SCRIPT_ENGINE_TYPE);
		
		for (String variable : variables) {
			variable = variable.substring(1);
			engine.put(variable, replacements.get(variable));
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
	
	public static void main(String[] args) {
		
		String value = "Olá eu sou Goku! <|false|>   testeValor <||> dsflksdj ";
		Map<String, String> replacements = new HashMap<String, String>();
		
		String result = ExpressionTranslator.process(value, replacements);
		
		System.out.println(result);
		
	}
	
}
