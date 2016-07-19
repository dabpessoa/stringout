package me.dabpessoa.stringout.service;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class EvaluateExpression {

	private static Map<ScriptTypes, MyScriptEngine> scriptEngineManagers;
	static {
		scriptEngineManagers = new HashMap<>();
		scriptEngineManagers.put(ScriptTypes.JAVASCRIPT, new EvaluateExpression().new MyScriptEngine(ScriptTypes.JAVASCRIPT));
	}
	
	public static ScriptEngineManager getScriptEngineManager(ScriptTypes scriptType) {
		return scriptEngineManagers.get(scriptType).getScriptEngineManager();
	}
	
	public static ScriptEngine getScriptEngine(ScriptTypes scriptType) {
		return scriptEngineManagers.get(scriptType).getScriptEngine();
	}
	
	public static enum ScriptTypes {
		JAVASCRIPT("JavaScript"),
		NASHORN("nashorn");
		
		private String description;
		
		private ScriptTypes(String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}
	};
	
	private class MyScriptEngine {
		ScriptEngineManager scriptEngineManager;
		ScriptEngine scriptEngine;
		
		public MyScriptEngine(ScriptTypes scriptType) {
			this.scriptEngineManager = new ScriptEngineManager();
			this.scriptEngine = scriptEngineManager.getEngineByName(scriptType.getDescription());
		}
		
		public ScriptEngine getScriptEngine() {
			return scriptEngine;
		}
		
		public ScriptEngineManager getScriptEngineManager() {
			return scriptEngineManager;
		}
	}
	
}
