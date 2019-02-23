package com.microservices.app.h2.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.exceptions.helpers.DateHelper;
import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;
import com.microservices.app.h2.service.H2ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class H2ControllerImpl implements H2Controller{
	
	@Autowired
	private H2ClientService service;
	@Autowired 
	private DateHelper dateHelper ;
	@Override
	public List<Client> getAllClients() {
		log.info(":: GET CONTROLLER :  getAllClients : RUNNING :::");
		return service.getAllClients();
	}

	@Override
	public String helloTest() {
		return"Hello";
	}

	@Override
	public List<Product> getAllProducts() {
		log.info(":: GET CONTROLLER :  getAllProducts : RUNNING :::");
		return  service.getAllProducts();
	}

	@Override
	public List<Product> getProductByDate(String dateFrom)  {
		List<Product> response = new ArrayList<Product>();
		log.info(":: GET CONTROLLER :  getProductByDate : RUNNING {} :::" ,dateFrom );
		dateHelper.isDateValid(dateFrom);
		
		response = 	service.getProductByDate(dateFrom);
		return response;
	}

	@Override
	public Product createClient(Product product) {
		log.info(":: POST  CONTROLLER :  createClient : RUNNING  REQUEST  {} " + product);
		throw new InvalidParameterException() ;
	}
	

}
