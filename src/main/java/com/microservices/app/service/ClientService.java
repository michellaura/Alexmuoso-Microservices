package com.microservices.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.app.domain.Clients;
import com.microservices.app.model.ClientsModel;
import com.microservices.app.repository.ClientRepositoryImpl;
import com.microservices.app.service.mappers.Transform;

@Service
public class ClientService {
	/*TO runtime loggs*/ 
	private static final Logger LETSLOGG = LoggerFactory.getLogger(ClientService.class);
	
	/*Initializing Repository*/ 
	@Autowired ClientRepositoryImpl repo;
	@Autowired Transform transform; 
	
	/*
	 * Calling repository
	 * Mapping model to domain response
	 * 
	 */ 
	public List<Clients> getAllClients() {
		LETSLOGG.info("Service getAllClients Running ");
		List<ClientsModel> modelResponse  = repo.getAllClients();
		List<Clients> response = transform.transformClientModelToClientService(modelResponse);
		return response ;
	}

	/*
	 * Receive request client
	 * map to model 
	 * send info to repo 
	 */
	public void createClient(Clients request) {
		LETSLOGG.info("POST SERVICE RUNNING");
		repo.createClient(transform.transformDoaminToModel(request));
	}

}
