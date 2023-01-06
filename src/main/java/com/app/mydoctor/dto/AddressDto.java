package com.app.mydoctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
	@JsonProperty("aaddressLine1")
	private String aaddressLine1;
	@JsonProperty("aaddressLine2")
	private String aaddressLine2;
	@JsonProperty("azipcode")
	private String azipcode;
	@JsonProperty("acity")
	private String acity;
	@JsonProperty("astate")
	private String astate;
	
	public AddressDto() {}

	public AddressDto(String aaddressLine1, String aaddressLine2, String azipcode, String acity, String astate) {
		super();
		this.aaddressLine1 = aaddressLine1;
		this.aaddressLine2 = aaddressLine2;
		this.azipcode = azipcode;
		this.acity = acity;
		this.astate = astate;
	}

	public String getAaddressLine1() {
		return aaddressLine1;
	}

	public void setAaddressLine1(String aaddressLine1) {
		this.aaddressLine1 = aaddressLine1;
	}

	public String getAaddressLine2() {
		return aaddressLine2;
	}

	public void setAaddressLine2(String aaddressLine2) {
		this.aaddressLine2 = aaddressLine2;
	}

	public String getAzipcode() {
		return azipcode;
	}

	public void setAzipcode(String azipcode) {
		this.azipcode = azipcode;
	}

	public String getAcity() {
		return acity;
	}

	public void setAcity(String acity) {
		this.acity = acity;
	}

	public String getAstate() {
		return astate;
	}

	public void setAstate(String astate) {
		this.astate = astate;
	}
	
	
	
}
