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


@Slf4j
@Component
public class MongoControllerImpl implements MongoController {

	@Autowired
	private ClientService service;
	@Autowired
	private ValidatorControllerRequests validator;

	public ResponseEntity<Object> createClient(@RequestBody Client request) {
		try {
			log.info(":::POST createClient :: CONTROLLER RUNNING:::");
			service.createClient(request);
		}catch (Exception e ) {
			log.info("GET  getclientbyname  EXCEPTION : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING HAPPENED PLEASE REVIEW LOGS " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}

	public List<Client> getAllClients() {
		log.info("::GET getAllClients :: CONTROLLER RUNNING");
		return service.getAllClients();
	}

	@Override
	public ResponseEntity<Object> getAllClientsByName(String name) {
		StringBuffer exceptionMessage = new StringBuffer();
		List<Client>response;

		validator.validateName(name, exceptionMessage);
		if (exceptionMessage.length() == 0) {

			try {
				response = service.getAllClientsByName(name);
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
