package com.microservices.app.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController	
@RequestMapping(value="/main")
@Api(value=" Microservices Main" , tags="Microservices Main ")
public class HelloController {

	
	
	@GetMapping("/hello")
	@ApiOperation(value=" say hello ",  notes="this operation will say hello " )
	@ApiResponses(value= {@ApiResponse(code = 200 , message =" Successful operation ")})
	public String sayHello() {
		return "hello man" ;
	}
}
