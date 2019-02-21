package com.microservices.app.h2.model.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Product {

	private long id;
	private String name;
	private Double price;
	private Date createAt;
}
