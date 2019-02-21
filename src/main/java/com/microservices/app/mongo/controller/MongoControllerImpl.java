package com.microservices.app.mongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.app.mongo.model.domain.Client;
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
			StringBuffer exceptionMessage = new StringBuffer();
			log.info(":::POST createClient :: CONTROLLER RUNNING  REQUEST {}  ,  ", request);

			log.info(":::POST createClient :: VALIDATE REQUEST {}  ,  ", request);
			validator.validateName(request.getName(), exceptionMessage);

			if (exceptionMessage.length() == 0) {

				log.info(":::POST createClient :: CONTROLLER  CALLING SERVICE  ::: ");
				service.createClient(request);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" REVIEW YOU PARAMAETERS : " + exceptionMessage);
			}
		} catch (Exception e) {
			log.info("GET  getclientbyname  EXCEPTION : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING HAPPENED PLEASE REVIEW LOGS " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}

	public  ResponseEntity<Object> getAllClients() {
		List<Client> response = new ArrayList<Client>();
		log.info("::GET getAllClients :: CONTROLLER RUNNING");
		try {
			response =  service.getAllClients();
			log.info("::GET getAllClients :: CONTROLLER  RESPONSE {} " ,  response);
		}
		catch (Exception e ) {
			log.info("GET  getAllClients  EXCEPTION : " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING HAPPENED PLEASE REVIEW LOGS " + e.getLocalizedMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}

	@Override
	public ResponseEntity<Object> getAllClientsWithName(String name) {
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
