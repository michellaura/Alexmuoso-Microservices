package com.microservices.app.h2.repository;

import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
@Component
public interface Repository {

	public void createClientByEntityManager(H2ClientDao clientDao);
	
}
