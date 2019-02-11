package com.microservices.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.app.domain.Client;
import com.microservices.app.service.ClientServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClientControllerImpl implements ClientController {

	@Autowired
	private ClientServiceImpl service;

	public String getAllClients(Model model) {
		log.info("::GET OPERATION CONTROLLER RUNNING::");
		List<Client> listClients = service.getAllClients();

		// Front-end part
		String message = "List all the clients from mongo";
		model.addAttribute("listClient", listClients);
		model.addAttribute("title", message);
		return "list";
	}

	public void createClient(@RequestBody Client request) {
		log.info("::POST RUNNING::");
		service.createClient(request);
	}

	@SuppressWarnings("null")
	public String findClientByName(String name) {
		log.info("::GET OPERATION CONTROLLER RUNNING::");
		Client response = service.findClientByName(name);

		// Front-end
		Model model = null;
		model.addAttribute("client", response);
		return "Microservices";
	}

	// FRON.END
	public String showMicroservices(Model model) {
		return "Microservices";
	}
}
