package me.dabpessoa.stringout;

public abstract class AbstractStringOut implements StringOut {

	private String encoding;
	private String filePath;
	
	public AbstractStringOut() {
		this.encoding = CHARACTER_ENCODING_DEFAULT;
		this.filePath = FILE_PATH_DEFAULT;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
