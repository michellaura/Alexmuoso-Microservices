package com.microservices.app.mongo.model.domain;

import lombok.Data;

@Data
public class Client {

	private String id;
	private String name;
	private String lastName;
	private int age;
	private String gender;
	
}
