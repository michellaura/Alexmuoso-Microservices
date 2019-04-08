package com.microservices.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@SpringBootApplication
public class MicroServicesOsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesOsoApplication.class, args);
	}//hehe

}
