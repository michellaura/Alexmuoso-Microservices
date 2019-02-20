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

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/mongo" ) 
@Api(value=" Microservices Mongo" , tags="Microservices Mongo ")
public interface MongoController {

	@RequestMapping(value = "/createclient", method = RequestMethod.POST   , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> createClient(@RequestBody Client request);
	
	@GetMapping(value="/getallclients")
	@ResponseStatus(HttpStatus.OK) 			
	public List<Client> getAllClients();
	
	@GetMapping(value="/getclientbyname")
	@ResponseStatus(HttpStatus.OK) 			
	public ResponseEntity<Object> getAllClientsByName(String name) ;
	
	
}
