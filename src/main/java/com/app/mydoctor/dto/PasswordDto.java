package com.app.mydoctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PasswordDto {
	@JsonProperty("newpasswords")
	private String newpasswords;
	
	public PasswordDto() {}

	public PasswordDto(String newpasswords) {
		super();
		this.newpasswords = newpasswords;
	}

	public String getNewpasswords() {
		return newpasswords;
	}

	public void setNewpasswords(String newpasswords) {
		this.newpasswords = newpasswords;
	}
	
	
	
}
