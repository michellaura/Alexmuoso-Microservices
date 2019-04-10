package com.microservices.app.h2.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.daos.ProductDao;

@Component
public interface Repository {

	public List<H2ClientDao> getAllClients();

	public List<ProductDao> getAllProducts() ;
	
	public List<ProductDao> getAllProductByDate(String dateFrom);

	public void createClientByEntityManager(H2ClientDao clientDao);
	
	public H2ClientDao getById(long id);

	public void deleteById(long id);

	public H2ClientDao updateClient(H2ClientDao client, long id);
}
