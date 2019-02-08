package com.microservices.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ClientsModel {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private int age;
	private String sex;
	
}
