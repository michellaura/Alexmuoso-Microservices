package com.microservices.app.h2.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.domain.Client;
import com.microservices.app.h2.model.domain.Product;

@Component
public interface H2ClientService {

	public List<Client> getAllClients();
	
	public H2ClientDao getClientById(Long id);
	
	public void deleteClientById(Long id);
	
	public H2ClientDao updateClient(H2ClientDao clienDao);
	
	public List<Product> getAllProducts();
	
	public List<Product> getProductByDate(String dateFrom);
	
	public void createClientByEntityManager(Client client);
}
