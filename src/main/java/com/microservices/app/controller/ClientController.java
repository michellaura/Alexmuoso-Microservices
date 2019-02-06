package com.microservices.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.domain.Clients;
import com.microservices.app.service.ClientService;

@RestController
@RequestMapping(value = "/microservices")
public class ClientController {

	private static final Logger LETSLOGG = LoggerFactory.getLogger(ClientController.class);// TO runtime loggs

	@Autowired
	private ClientService service;// Initializing Service

	@GetMapping("/getall")
	@ResponseStatus(HttpStatus.OK) // This operation will be return all the clients in mongo DOCS
	public List<Clients> getAllClients() {
		LETSLOGG.info("Running GET ALL OPERATION");
		return service.getAllClients();
	}

}
