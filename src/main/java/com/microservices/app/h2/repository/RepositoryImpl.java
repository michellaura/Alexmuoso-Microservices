package com.microservices.app.h2.repository;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.daos.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RepositoryImpl implements Repository {

	@Autowired
	private Jpa jpa;
	
	@Autowired
	private H2ClientRepository clientRepo;
	
	@Autowired
	private ProductRepository productRepo;
	private EntityManagerFactory emf  =  Persistence.createEntityManagerFactory("PERSISTENCE");
	
	
	@Override
	public List<H2ClientDao> getAllClients() {
		log.info(":: GET  getAllClients  REPO  ::  GET ALL CLIENTS RUNNING");
		List<H2ClientDao> daoResponse = (List<H2ClientDao>) clientRepo.findAll();
		log.info(":: GET  getAllClients  REPO  ::  RESPONSE {}", daoResponse);
		return daoResponse;
	}
	@Override
	public List<ProductDao> getAllProducts() {
		log.info(":: GET getAllProducts  REPO  ::  GET ALL CLIENTS RUNNING");
		List<ProductDao> daoResponse = (List<ProductDao>) productRepo.findAll();
		log.info(":: GET getAllProducts  REPO  ::  RESPONSE {}", daoResponse);
		return daoResponse;
	}
	@Override
	public List<ProductDao> getAllProductByDate(String dateFrom) {
		log.info(":: GET getAllProductByDate  REPO  ::  GET ALL PRODUCTS RUNNING DATE : {} ", dateFrom);
		List<ProductDao> daoResponse =  productRepo.getAllProductsByDate(dateFrom);
		log.info(":: GET getAllProductByDate  REPO  ::  RESPONSE {}", daoResponse);
		return daoResponse;
	}
	@Override
	public void createClientByEntityManager(H2ClientDao clientDao) {
		log.info(":: POST createClientByEntityManager  REPO  :: ClientDao  {}", clientDao);
		log.info(":: Insert clientDao Entity  :: {}" , clientDao);
		jpa.save(clientDao);  
		
	} 

}
