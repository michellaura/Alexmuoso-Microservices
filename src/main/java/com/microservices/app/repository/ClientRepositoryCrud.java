package com.microservices.app.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.app.model.ClientModel;

public interface ClientRepositoryCrud extends MongoRepository<ClientModel, UUID>{
	/*
	 * This Repository Method will go to the MOngo DB and insert Clients in
	 * Docs.
	 * getAllClients
	 * 
	 */
	/*
	 * This Repository Method will go to the MOngo DB and take all the Clients in
	 * Docs.
	 * createClient
	 * 
	 */
	
	//findBy Name
	public ClientModel findByName(String name);
}
