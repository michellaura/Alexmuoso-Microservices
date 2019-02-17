package com.microservices.app.mongo.domain;

import lombok.Data;

@Data
public class Client {

	private String name;
	private String lastName;
	private int age;
	private String gender;
	
}
