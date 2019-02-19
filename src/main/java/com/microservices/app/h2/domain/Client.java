package com.microservices.app.h2.domain;

import lombok.Data;

@Data
public class Client {
	private long id;
	private String name;
	private String lastName;
	private String age;
	private String gender;

}
