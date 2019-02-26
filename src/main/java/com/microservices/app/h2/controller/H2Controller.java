package com.microservices.app.h2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/hdos")
@Api(value=" Microservices H2" , tags="Microservices H2 ")
public interface H2Controller {
	
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN HELLO ")
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.OK) 			
			@GetMapping(value="/test")
			public String helloTest();

		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE CLIENTS IN H2 PERISTENCE DB", response = Client.class )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.OK) 			
			@GetMapping(value="/getallclients")
			public List<Client> getAllClients();

		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE PRODUCTS IN H2 PERISTENCE DB", response = Product.class )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.OK) 			
			@GetMapping(value="/getallproducts")
			public List<Product> getAllProducts();
	
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL RETURN ALL THE PRODUCTS which were created between date param sent and today ", response = Product.class )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.OK) 			
			@GetMapping(value="/getproductsbydatecreatedtotodaydate" )
			public List<Product> getProductByDate(String dateFrom ) ;
		
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL CREATE A NEW CLIENT IN H2 PERSISTENCE DATA BASE " )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.CREATED) 			
			@PostMapping(value="/createclient" )
			public Product createClient(@RequestBody Product product );
		
		@ApiOperation(value=" ",  notes="THIS OPERATION WILL CREATE A NEW CLIENT IN H2 PERSISTENCE DATA BASE BY ENTITY MANAGER OF HIBERNATE" )
		@ApiResponses(value= {@ApiResponse(code = 200 , message =" SUCCESS OPERATION ")})
			@ResponseStatus(HttpStatus.CREATED) 			
			@PostMapping(value="/createclientwithentitymanager" )
			public ResponseEntity<String> createClientWithEntityManager(@RequestBody Client client );
	 
}
