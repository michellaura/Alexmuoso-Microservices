package com.microservices.app.h2.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservices.app.h2.daos.H2ClientDao;


public interface H2ClientRepository extends CrudRepository<H2ClientDao, Long>{
	
	
}
