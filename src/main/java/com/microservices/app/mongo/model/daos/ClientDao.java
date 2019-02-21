package com.microservices.app.mongo.model.daos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("CLIENTS")
public class ClientDao {
	
	@Id
	private String id;
	private String name;
	private String lastName;
	private int age;
	private String gender;
	
}
