package com.microservices.app.h2.exceptions;

import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.app.h2.exceptions.helpers.DateHelper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
	
	
	@ResponseBody
	@ExceptionHandler(InvalidParameterException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public Error invalidParameterException(InvalidParameterException ex) {
		log.info(":: GLOBAL EXCEPTION HANDLER   :   InvalidParameterException  {}" + ex.getMessage() );
		return new Error(HttpStatus.BAD_REQUEST.value(), MessageFormat.format( ex.getMessage() , ex.getMessage() )); 
		
	}
	
	@ResponseBody
	@ExceptionHandler(DateTimeParseException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public Error invalidParameterException(DateTimeParseException ex) {
		log.info(":: GLOBAL EXCEPTION HANDLER   :   DateTimeParseException  {}" + ex.getMessage() );
		return new Error(HttpStatus.BAD_REQUEST.value(), MessageFormat.format( " Invalid Date " + ex.getMessage() + " please follow below format " + DateHelper.JSON_DATE_TIME_FORMAT , ex.getMessage())); 
		
	}
	
}
