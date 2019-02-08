package com.microservices.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.domain.Clients;
import com.microservices.app.service.ClientService;

@RestController
@RequestMapping(value = "/microservices")
public class ClientController {
	// TO runtime loggs
	private static final Logger LETSLOGG = LoggerFactory.getLogger(ClientController.class);			

    // Initializing Service
	@Autowired
	private ClientService service;					
 
	/*
	 * Mappign url
	 * statust for response
	 * method which receive a body of a class an map by attributes
	 * calling service
	 */
	@RequestMapping(value = "/createclient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void createClient(@RequestBody Clients request) {
		LETSLOGG.info("POST RUNNING");
		service.createClient(request);
	}

	
	/*  This operation will be return all the clients in mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping("/getall")
	@ResponseStatus(HttpStatus.OK) 					 
	public List<Clients> getAllClients() {
		LETSLOGG.info("GET OPERATION CONTROLLER RUNNING");
		return service.getAllClients(); 			 
	}

}
