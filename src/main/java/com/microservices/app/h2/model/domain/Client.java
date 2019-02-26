package com.microservices.app.h2.model.domain;

import lombok.Data;

@Data
public class Client {
	private String id;
	private String name;
	private String lastName;
	private String age;
	private String gender;

}
