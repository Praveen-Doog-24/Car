package com.te.markupcar.model;

public class AuthenticationResponse {
	private boolean err;
	private String msg;
	private final String jwt;
	
		

	
	

	




	public boolean isErr() {
		return err;
	}




	public void setErr(boolean err) {
		this.err = err;
	}




	
	




	public AuthenticationResponse(boolean err, String msg, String jwt) {
		super();
		this.err = err;
		this.msg = msg;
		this.jwt = jwt;
		
	}




	public String getMsg() {
		return msg;
	}









	public void setMsg(String msg) {
		this.msg = msg;
	}




	public String getJwt() {
		return jwt;
	}
	

}
