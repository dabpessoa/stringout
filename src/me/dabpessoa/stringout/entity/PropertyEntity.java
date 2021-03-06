package me.dabpessoa.stringout.entity;

import java.io.Serializable;

/**
 * @author dabpessoa [www.dabpessoa.me]
 * @since 28/06/2016
 */
public class PropertyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String key;
	private String value;
	
	public PropertyEntity() {}

	public PropertyEntity(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
