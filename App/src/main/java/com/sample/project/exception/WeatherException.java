package com.sample.project.exception;

import org.springframework.http.HttpStatus;

public class WeatherException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus code;

	public WeatherException() {
		super();
	}

	public WeatherException(final String message,final HttpStatus code) {
		super(message);
		this.code=code;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
	
	
}
