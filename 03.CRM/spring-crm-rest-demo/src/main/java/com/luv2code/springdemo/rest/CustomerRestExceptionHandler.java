package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// add another exception handler
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {

		// create a StudentErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {

		// create a StudentErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
