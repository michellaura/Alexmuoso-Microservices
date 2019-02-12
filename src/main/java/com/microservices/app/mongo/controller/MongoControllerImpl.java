package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.service.ClientServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MongoControllerImpl implements MongoController {

	@Autowired
	private ClientServiceImpl service;


	public String getAllClients(Model model) {
		log.info("::GET OPERATION CONTROLLER RUNNING::");
		List<Client> listClients = service.getAllClients();

		// Front-end part
		model.addAttribute("response", listClients);
		return "mongo_view";
	}
	
	public String createClient(@RequestBody Client request,Model model) {
		log.info("::POST RUNNING:: REQUEST " + request);
		service.createClient(request);
		
		// Front end
		model.addAttribute("message","THE CLIENT WAS CREATED");
		return "mongo_view";

	}

	public String findClientByName(String name, Model model) {
		log.info("::GET OPERATION CONTROLLER RUNNING::");
		Client response = service.findClientByName(name);

		// Front-end
		model.addAttribute("response", response);
		return "mongo_view";
	}

	/*
	 * FRONT END
	 * */
	public String displayMongoView(Model model) {
		return "mongo_view";
	}
	public String displayMicroservicesView(Model model) {
		return "microservices_view";
	}
}
