package com.microservices.app.h2.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.daos.ProductDao;
import com.microservices.app.h2.model.domain.Client;

@Component
public interface Repository {

	public List<H2ClientDao> getAllClients();

	public List<ProductDao> getAllProducts() ;
	
	public List<ProductDao> getAllProductByDate(String dateFrom);

	public void createClientByEntityManager(H2ClientDao clientDao);
	//Servicio
	//public void createClientByEntityManager(Client client);
	
	public H2ClientDao getById(long id);
//	public H2ClientDao getById(long id);
	//Servicio
	//public H2ClientDao getById(long id);

	public void deleteById(long id);

	public H2ClientDao updateClient(H2ClientDao client, long id);
}
