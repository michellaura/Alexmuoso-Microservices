package com.microservices.app.h2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.h2.mapper.OrikaMapper;
import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.daos.ProductDao;
import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;
import com.microservices.app.h2.repository.Repository;
import com.microservices.app.h2.repository.RepositoryImpl;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import net.bytebuddy.utility.RandomString;

@Slf4j
@Component
public class H2ClientServiceImpl implements H2ClientService {

	@Autowired
	private	Repository repo;
	
	private MapperFacade facade = new OrikaMapper();
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		log.info(":: GET   getAllClients SERVICE :: RUNNING");
		List<H2ClientDao> reponseDao = repo.getAllClients();
		log.info(":: GET   getAllClients  SERVICE ::  DB INFO {} " , reponseDao);
		List<Client> response = new ArrayList<Client>();
		reponseDao.stream().forEach((clientDao) -> {
			log.info(":: GET getAllClients  SERVICE - MAPPER ::  DB INFO {} " , clientDao);
			response.add(facade.map(clientDao, Client.class));

		});
		log.info(":: GET getAllClients SERVICE :: RETURN RESPONSE  {}", response);
		return response;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		log.info(":: GET getAllProducts   SERVICE :: RUNNING");
		List<ProductDao> reponseDao = repo.getAllProducts();
		log.info(":: GET getAllProducts   SERVICE ::  DB INFO {} " , reponseDao);
		List<Product> response = new ArrayList<Product>();
		
		reponseDao.stream().forEach((product) -> {
			log.info(":: GET  getAllProducts   SERVICE - MAPPER ::  DB INFO {} " , product);
			response.add(facade.map(product, Product.class));

		});

		log.info(":: GET getAllProducts    SERVICE :: RETURN RESPONSE  {}", response);
		return response;
	}


	@Override
	public List<Product> getProductByDate(String dateFrom) {
		log.info(":: GET getProductByDate   SERVICE :: RUNNING  DATE REQUEST  : {} " , dateFrom);
		List<ProductDao> reponseDao = repo.getAllProductByDate(dateFrom);
		log.info(":: GET getProductByDate   SERVICE ::  DB INFO {} ", reponseDao);
		List<Product> response = new ArrayList<Product>();

		reponseDao.stream().forEach((product) -> {
			log.info(":: GET getProductByDate   SERVICE - MAPPER ::  DB INFO {} ", product);
			response.add(facade.map(product, Product.class));

		});

		log.info(":: GET  getProductByDate    SERVICE :: RETURN RESPONSE  {}", response);
		return response;
	}


	@Override
	@javax.transaction.Transactional
	public void createClientByEntityManager(Client client) {
		log.info(":: POST createClientByEntityManager   SERVICE :: RUNNING  DATE REQUEST {}", client);

		log.info(":: POST createClientByEntityManager   SERVICE - MAPPER ");
		H2ClientDao clientDao = new H2ClientDao();
		clientDao.setName(client.getName());
		clientDao.setLastName(client.getLastName());
		clientDao.setAge(client.getAge());
		clientDao.setGender(client.getGender());
		
		log.info(":: POST createClientByEntityManager    SERVICE :: CALL REPO  Dao {}", clientDao);
		repo.createClientByEntityManager(clientDao);

	}
	
}
