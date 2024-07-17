package com.accenture.granja.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
	public class GlobalExceptionHandler {

	    @ExceptionHandler(NoContentException.class)
	    public ResponseEntity<String> handleNoContentException(NoContentException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	}