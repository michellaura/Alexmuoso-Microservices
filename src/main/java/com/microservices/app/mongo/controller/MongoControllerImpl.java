package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MongoControllerImpl implements MongoController {

	@Autowired
	private ClientService service;
	@Autowired
	private ValidatorControllerRequests validator;

	public void createClient(@RequestBody Client request) {
		log.info(":::POST createClient :: CONTROLLER RUNNING:::");
		service.createClient(request);
	}

	public List<Client> getAllClients() {
		log.info("::GET getAllClients :: CONTROLLER RUNNING");
		return service.getAllClients();
	}

	@Override
	public ResponseEntity<Object> getclientbyname(String name) {
		StringBuffer exceptionMessage = new StringBuffer();
		Client response;

		validator.validateName(name, exceptionMessage);
		if (exceptionMessage.length() == 0) {

			try {
				response = service.getByName(name);
			} catch (RuntimeException e) {
				log.info("GET  getclientbyname  EXCEPTION : " + e.getMessage());
				return ResponseEntity.status(HttpStatus.OK).body(" NO DATA FOUND WITH NAME :  " + name);
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionMessage);
		}
		return ResponseEntity.ok(response);
	}

}
