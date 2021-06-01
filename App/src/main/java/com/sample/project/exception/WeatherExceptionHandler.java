package com.sample.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class WeatherExceptionHandler {

	@ExceptionHandler(WeatherException.class)
	public ResponseEntity<Object> handleWeatherException(final WeatherException exception) {

		return new ResponseEntity<Object>(exception.getMessage(), exception.getCode());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleWeatherException(final Exception exception) {

		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
