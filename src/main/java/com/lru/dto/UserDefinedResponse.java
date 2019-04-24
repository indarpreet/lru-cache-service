package com.lru.dto;

import com.lru.constant.HttpStatus;

public class UserDefinedResponse {

	private String message;
	private Object response;

	public UserDefinedResponse() {
		
	}
	
	
	public UserDefinedResponse(HttpStatus message, Object response) {
		super();
		this.message = message.getReasonPhrase();
		this.response = response;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(HttpStatus message) {
		this.message = message.getReasonPhrase();
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

}
