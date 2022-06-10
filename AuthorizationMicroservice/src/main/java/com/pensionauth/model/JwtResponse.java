package com.pensionauth.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String token;
	private String validity;
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getToken() {
		return token;
	}
	public JwtResponse(String token, String validity) {
		super();
		this.token = token;
		this.validity = validity;
	}
	
	
	
	


}