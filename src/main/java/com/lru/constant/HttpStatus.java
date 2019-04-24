package com.lru.constant;

public enum HttpStatus {
	
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
	OK(200, "Successfully Updated"),
	NOT_FOUND(404, "Not Found");
	
	private final int value;

	private final String reasonPhrase;
	
	HttpStatus(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the reasonPhrase
	 */
	public String getReasonPhrase() {
		return reasonPhrase;
	}
		

}
