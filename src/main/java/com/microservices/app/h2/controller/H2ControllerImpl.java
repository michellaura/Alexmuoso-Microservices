package com.microservices.app.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.exceptions.DateHelper;
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
		log.info("GET CONTROLLER :  getAllClients : RUNNING :::");
		return service.getAllClients();
	}

	@Override
	public String helloTest() {
		return"Hello";
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("GET CONTROLLER :  getAllProducts : RUNNING :::");
		return  service.getAllProducts();
	}

	@Override
	public List<Product> getProductByDate(String dateFrom) {
		List<Product> response = new ArrayList<Product>();
		log.info("GET CONTROLLER :  getProductByDate : RUNNING :::");
		MDC.put("URIPattern", "GET /h2/getproductsbydatecreatedtotodaydate" );
		StringBuffer exceptionMessage = new StringBuffer();
		try {
			dateHelper.isDateValid(dateFrom , exceptionMessage);
			if(exceptionMessage.length()>0 ) {
				return null; //add 400
			}else
			{
				response = 	service.getProductByDate(dateFrom);
			}
		}catch( Exception e ) {
			
		}
		return response;
	}
	

}
