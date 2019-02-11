package com.microservices.app.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ClientModel {
	
	@Id
	private UUID _id;
	private String name;
	private String lastName;
	private int age;
	private String sex;
	
}
