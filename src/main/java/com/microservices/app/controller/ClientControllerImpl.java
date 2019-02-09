package com.microservices.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.microservices.app.domain.Client;
import com.microservices.app.service.ClientServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientControllerImpl implements ClientController {

	@Autowired
	private ClientServiceImpl service;

	public void createClient(@RequestBody Client request) {
		log.info("POST RUNNING");
		service.createClient(request);
	}

	@SuppressWarnings("null")
	public String findClientByName(String name) {
		
		log.info("GET OPERATION CONTROLLER RUNNING");
		Client response = service.findClientByName(name);

		// Front-end
		Model model = null;
		model.addAttribute("client", response);
		return "Microservices";
	}

	@GetMapping(value = "/getallclients")
	@ResponseStatus(HttpStatus.OK)
	public String getAllClients(Model model) {
		log.info("GET OPERATION CONTROLLER RUNNING");
		List<Client> listClients = service.getAllClients();

		// Front-end part
		model.addAttribute("response", listClients);
		return "Microservices";
	}

}
