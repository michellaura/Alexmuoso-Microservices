package com.microservices.app.mongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.microservices.app.mongo.domain.Client;

@Controller
@RequestMapping(value = "/mongo")
public interface MongoController {


	
	/*  This operation will be return all the clients from mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping(value ="/getallclients")
	@ResponseStatus(HttpStatus.OK) 					 
	public String getAllClients(Model model) ;
	/*
	 * Mappign url
	 * statust for response
	 * method which receive a body of a class an map by attributes
	 * calling service
	 */
	@RequestMapping(value = "/createclient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView createClient(@RequestBody Client request, BindingResult result); //RequestBody
	/*  This operation will be return a client from mongo DOCS
	 *  LOGG INFORMARION
	 *	CALLING SERVICE
	 */ 
	@GetMapping(value ="/getclient")
	@ResponseStatus(HttpStatus.OK) 					 
	public String findClientByName(String name, Model model);
	
	/*
	 * FRONT END - VIEWS 
	 * */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayMongoView (Model model);

}
