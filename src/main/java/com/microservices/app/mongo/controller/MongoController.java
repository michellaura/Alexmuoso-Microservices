package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.mongo.model.domain.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/mongo" ) 
@Api(value=" Microservices Mongo" , tags="Microservices Mongo ")
public interface MongoController {
	
	
	@ApiOperation(value=" ",  notes="THIS OPERATION WILL CREATE A CLIENT IN MONGO DOCS CLUSTER", response = Client.class )
	@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
		@PostMapping(value = "/createclient", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.CREATED)                   
		public ResponseEntity<Object> createClient(@RequestBody Client request);
	
	
	@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE CLIENTS IN MONGO CLUSTER", response = Client.class )
	@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
		@GetMapping(value="/getallclients")
		@ResponseStatus(HttpStatus.OK) 			
		public ResponseEntity<Object> getAllClients();
	
	
	@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL CLIENTS BY NAME", response = Client.class )
	@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
	//*** Swagger - Documentation ****
		@GetMapping(value="/getallclientswithname")
		@ResponseStatus(HttpStatus.OK) 			
		public ResponseEntity<Object> getAllClientsWithName(String name) ;
	
	
}
