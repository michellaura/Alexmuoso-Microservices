package com.microservices.app.mongo.controller;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ValidatorControllerRequests {

	public void validateName(String name, StringBuffer exceptionMessage) {
		log.info("::GET CREATE CLIENT  :: VALIDATOR NAME :  {} " , name);
		 if(name==null || name.isEmpty() ) { 
			 exceptionMessage.append( " name " + name + " is invalid "); 
		 }
		 else {
			 log.info("::GET CREATE CLIENT  EXCEPTION   :: " +exceptionMessage);
		 }
	}
	
}
