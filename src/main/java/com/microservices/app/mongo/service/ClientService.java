package com.microservices.app.mongo.service;

import java.util.List;

import com.microservices.app.mongo.domain.Client;

public interface ClientService {
	/*
	 * Calling repository
	 * Mapping model to domain response
	 * 
	 */ 
	public List<Client> getAllClients();
	/*
	 * Calling repository
	 * Mapping model to domain response
	 * 
	 */ 
	public Client findClientByName(String name) ;

	
	
	/*
	 * Receive request client
	 * map to model 
	 * send info to repo 
	 */
	public void createClient(Client request) ;

	

}
