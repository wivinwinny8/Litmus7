package com.litmus7.userregistration.model;

public class Response {
	private int statusCode;
	private String errorMessage;

	public Response() {
		statusCode = 200;
		errorMessage = "None";
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
