package com.microservices.app.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
@RequestMapping(value="/main")
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello man" ;
	}
}
