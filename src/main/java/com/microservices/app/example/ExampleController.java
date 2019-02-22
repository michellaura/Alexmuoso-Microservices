package com.microservices.app.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController	
@RequestMapping(value="/example")
@Api(value=" Microservices example " , tags=" Microservices example  ")
public class ExampleController {

	@GetMapping("/helloworld")
	@ApiOperation(value=" SAY HI ",  notes="This operation is only an example of how a http request return HELLO WORLD " )
	@ApiResponses(value= {@ApiResponse(code = 200 , message =" Successful operation ")})
	public String sayHello() {
		return "HELLO WORLD" ;
	}
}
