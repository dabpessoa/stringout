package me.dabpessoa.stringout;

public abstract class AbstractStringOut implements StringOut {

	private String encoding;
	
	public AbstractStringOut() {
		this.encoding = CHARACTER_ENCODING_DEFAULT;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
}
