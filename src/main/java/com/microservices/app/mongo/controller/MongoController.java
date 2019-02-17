package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.mongo.domain.Client;

@RestController
@RequestMapping(value = "/mongo" ) 
public interface MongoController {
	/*
	 * Mappign url
	 * statust for response
	 * method which receive a body of a class an map by attributes
	 * calling service
	 */
	@RequestMapping(value = "/createclient", method = RequestMethod.POST   , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void createClient(@RequestBody Client request);
	
	/*  This operation will be return all the clients in mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping(value="/getallclients")
	@ResponseStatus(HttpStatus.OK) 			
	public List<Client> getAllClients();
	
	@GetMapping(value="/getclientbyname")
	@ResponseStatus(HttpStatus.OK) 			
	public ResponseEntity<Object> getAllClientsByName(String name) ;
	
	
}
