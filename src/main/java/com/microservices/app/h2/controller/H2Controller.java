package com.microservices.app.h2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;

@RestController
@RequestMapping(value="/hdos")
public interface H2Controller {
	
		@GetMapping("/test")
		public String helloTest();
	
		@RequestMapping(value="/getallclients")
		public List<Client> getAllClients();
		
		@RequestMapping(value="/getallproducts")
		public List<Product> getAllProducts();
	
}
