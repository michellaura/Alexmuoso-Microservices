package com.microservices.app.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.model.ClientDao;
import com.microservices.app.mongo.repository.ClientRepositoryImpl;
import com.microservices.app.mongo.service.mappers.Transform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired ClientRepositoryImpl repo;
	@Autowired Transform transform; 
	
	public List<Client> getAllClients() {
		log.info("::GET getAllClients  SERVICE :: CALL REPO  ");
		List<ClientDao> modelResponse  = repo.getAllClients();
		log.info("::GET getAllClients  SERVICE :: MAPPING DAO TO RESPONSE  ");
		List<Client> response = transform.transformClientModelToClientService(modelResponse);
		log.info("::GET getAllClients  SERVICE :: RESPONSE {}  ",response);
		return response ;
	}

	public void createClient(Client request) {
		log.info("::POST createClient  SERVICE :: CALL REPO  ");
		repo.createClient(transform.transformDoaminToModel(request));
	}

}
