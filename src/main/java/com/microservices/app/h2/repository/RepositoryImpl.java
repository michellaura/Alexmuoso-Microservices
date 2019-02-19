package com.microservices.app.h2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.daos.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RepositoryImpl {

	@Autowired
	private H2ClientRepository clientRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<H2ClientDao> getAllClients() {
		log.info(":: GET  getAllClients  REPO  ::  GET ALL CLIENTS RUNNING");
		List<H2ClientDao> daoResponse = (List<H2ClientDao>) clientRepo.findAll();
		log.info(":: GET  getAllClients  REPO  ::  RESPONSE {} ", daoResponse);
		return daoResponse;
	}

	public List<ProductDao> getAllProducts() {
		log.info(":: GET getAllProducts  REPO  ::  GET ALL CLIENTS RUNNING");
		List<ProductDao> daoResponse = (List<ProductDao>) productRepo.findAll();
		log.info(":: GET getAllProducts  REPO  ::  RESPONSE {} ", daoResponse);
		return daoResponse;
	}

}
