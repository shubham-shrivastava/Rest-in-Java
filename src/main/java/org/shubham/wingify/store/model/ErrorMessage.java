package org.shubham.wingify.store.model;

public class ErrorMessage {
	private String message;
	private int code;
	private String documentation;
	
	
	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(String message, int code, String documentation) {
		super();
		this.message = message;
		this.code = code;
		this.documentation = documentation;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
