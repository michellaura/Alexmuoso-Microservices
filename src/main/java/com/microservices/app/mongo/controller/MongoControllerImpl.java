package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MongoControllerImpl implements MongoController{
	
	@Autowired
	private ClientService service;					
	
	public void createClient(@RequestBody Client request) {
		log.info(":::POST createClient :: CONTROLLER RUNNING:::");
		service.createClient(request);
	}

	public List<Client> getAllClients() {
		log.info("::GET getAllClients :: CONTROLLER RUNNING");
		return service.getAllClients(); 			 
	}
}
