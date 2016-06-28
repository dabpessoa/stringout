package me.dabpessoa.stringout;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class JSONEntity implements Serializable {
	private static final long serialVersionUID = -3644395619945804830L;
	
	@SerializedName("id")
	private String id;
	
	@SerializedName("value")
	private String value;
	
	public JSONEntity() {}
	
	public JSONEntity(String id, String value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		if (value != null) {
			return value.trim();
		}
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
