package com.microservices.app.h2.exceptions.modified;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException {

	public InvalidParameterException (String message) {
		super(message);
	}
}
