package com.microservices.app.h2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservices.app.h2.daos.H2ClientDao;

public class H2ClientRepositoryImpl  {

	@Autowired 
	private H2ClientRepository repo;
	
	public List<H2ClientDao> getAllClients() {
		List<H2ClientDao> DaoResponse= (List<H2ClientDao>) repo.findAll();
		return DaoResponse;
	}
	
	
}
