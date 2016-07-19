package me.dabpessoa.stringout.entity;

import java.io.Serializable;

public class Entity implements Serializable {
	private static final long serialVersionUID = -1641337198407291606L;
	
	private String key;
	private String value;
	
	public Entity() {}

	public Entity(String key, String value) {
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
