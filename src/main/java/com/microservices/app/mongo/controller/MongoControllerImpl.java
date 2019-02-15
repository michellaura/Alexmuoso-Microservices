package com.microservices.app.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	public ModelAndView createClient(@RequestBody Client request, BindingResult result) {
		log.info("::POST RUNNING:: REQUEST " + request);
		service.createClient(request);
		
		// Front end
		 ModelAndView model = new ModelAndView();
	        model.addObject("client", request);
	        model.setViewName(result.hasErrors() ? "mongo_view" : "mongo_view"); 
       return model;
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
