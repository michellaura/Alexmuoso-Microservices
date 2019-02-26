package com.microservices.app.mongo.service;

import java.util.List;

import com.microservices.app.mongo.model.domain.Client;

public interface ClientService {
	
	public List<Client> getAllClients() ;

	public void createClient(Client request) ;
	
	public List<Client>getAllClientsByName(String name) throws  RuntimeException ;

}
