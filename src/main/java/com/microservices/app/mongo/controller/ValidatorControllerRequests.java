package com.microservices.app.mongo.controller;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ValidatorControllerRequests {

	public void validateName(String name, StringBuffer exceptionMessage) {
		log.info("::GET clientByName :: validator name ");
		if( name == null || name.isEmpty() ) {
			exceptionMessage.append( " name " + name + " is invalid ");
			log.info("::GET clientByName  EXCEPTION   :: " +exceptionMessage);
		}
	}
	
}
