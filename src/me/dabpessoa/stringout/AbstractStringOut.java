package me.dabpessoa.stringout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public abstract class AbstractStringOut implements StringOut {

	private String encoding;
	private String filePath;
	
	public AbstractStringOut() {
		this.encoding = CHARACTER_ENCODING_DEFAULT;
		this.filePath = FILE_PATH_DEFAULT;
	}
	
	@Override
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
	
	public InputStream findInputStreamClassPathFile() throws IOException {
		return this.getClass().getClassLoader().getResourceAsStream(getFilePath());
	}

	public String toString(byte[] bytes) {
		return new String(bytes, Charset.forName(getEncoding()));
	}
	
	public byte[] findBytesClassPathFile() throws IOException {
		InputStream inputStream = findInputStreamClassPathFile();
		if (inputStream == null) throw new RuntimeException("Não foi possível localizar o arquivo: "+getFilePath());
		return getBytes(inputStream);
	}

	public static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();
		}
		return buf;
	}
	
}
