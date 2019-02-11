package com.microservices.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.microservices.app.domain.Client;

@Controller
@RequestMapping(value = "/microservices")
public interface ClientController {
	/*
	 * Mappign url
	 * statust for response
	 * method which receive a body of a class an map by attributes
	 * calling service
	 */
	@RequestMapping(value = "/createclient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String createClient(@RequestBody Client request); //RequestBody
	
	/*  This operation will be return a client from mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping(value ="/getclient")
	@ResponseStatus(HttpStatus.OK) 					 
	public String findClientByName(String name);
	
	/*  This operation will be return all the clients from mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping(value ="/getallclients")
	@ResponseStatus(HttpStatus.OK) 					 
	public String getAllClients() ;

	/*
	 * Show views
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showMicroservices (Model model);
	@RequestMapping(value="/showInsertClientView", method=RequestMethod.GET)
	public String showInsertClientView(Model model);
}
