package me.dabpessoa.stringout.service;

public enum ExpressionOperators {

	/*
	 * JavaScript operators similar.
	 */
	
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	EQUALS("=="),
	NOT_EQUALS("!="),
	GREATER_THEN(">"),
	LESS_THEN("<"),
	GREATER_THEN_OR_EQUALS(">="),
	LESS_THEN_OR_EQUALS("<="),
	OR("||"),
	AND("&&"),
	NOT("!"),
	PARENTESIS_LEFT("("),
	PARENTESIS_RIGHT(")");
	
	private String symbol;
	
	private ExpressionOperators(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public ExpressionOperators findExpressionOperator(String symbol) {
		if (symbol == null) return null;
		ExpressionOperators[] eos = values();
		for (ExpressionOperators eo : eos) {
			if (eo.getSymbol().trim().equals(symbol.trim())) {
				return eo;
			}
		} return null;
	}
	
}
