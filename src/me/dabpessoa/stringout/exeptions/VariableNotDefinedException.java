package me.dabpessoa.stringout.exeptions;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class VariableNotDefinedException extends Exception {
	private static final long serialVersionUID = 1L;

	public VariableNotDefinedException(String message) {
		super(message);
	}

	public VariableNotDefinedException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public VariableNotDefinedException(Throwable throwable) {
		super(throwable);
	}
	
}
