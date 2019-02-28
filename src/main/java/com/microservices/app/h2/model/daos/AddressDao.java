package com.microservices.app.h2.model.daos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="ADDRESS")
public class AddressDao {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID")
	private long id;
	@Column(name="STREET")
	private String street; 
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="ZIP")
	private String zip;
	
}
