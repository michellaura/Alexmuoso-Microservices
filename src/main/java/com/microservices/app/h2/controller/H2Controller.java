package com.microservices.app.h2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/hdos")
@Api(value=" Microservices H2" , tags="Microservices H2 ")
public interface H2Controller {
	
		@GetMapping("/test")
		public String helloTest();
	
		@GetMapping(value="/getallclients")
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE CLIENTS IN H2 PERISTENCE DB", response = Client.class )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
		public List<Client> getAllClients();
		
		@GetMapping(value="/getallproducts")
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE PRODUCTS IN H2 PERISTENCE DB", response = Client.class )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
		public List<Product> getAllProducts();
}
