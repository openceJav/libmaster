package com.opencejav.LibMaster.tools;

public class Response {
	private String message;
	private String type;
	
	public Response(String message, String type) {
		this.message = message;
		this.type = type;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return this.type;
	}
}
