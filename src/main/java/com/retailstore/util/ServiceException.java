package com.retailstore.util;

import java.util.Locale;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private int code;
	
	public ServiceException(int code, String message) {
		super(message, null);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public enum Status {
		INFO_MESSAGE(1000, "User Message"),
		API_CALLS_USED(1002, "API Calls Used"),

		NOT_FOUND(404,"Not Found"),
		// Success_Reserved
		SUCCESS(2000, "Success"),;
		
		private int code;
		private String defaultMessage;

		private Status(int code, String defaultMessage) {
			this.code = code;
			this.defaultMessage = defaultMessage;
		}

		public int getCode() {
			return code;
		}
		
		public String getDefaultMessage() {
			return defaultMessage;
		}
	}
}
