package com.microservices.app.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.app.domain.Client;
import com.microservices.app.model.ClientModel;
import com.microservices.app.repository.ClientRepositoryImpl;
import com.microservices.app.service.mappers.Transform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired ClientRepositoryImpl repo;
	@Autowired Transform transform; 
	
	public List<Client> getAllClients() {
		log.info("::SERVICE:: GET ALL CLIENTS RUNNING");
		List<ClientModel> modelResponse  = repo.getAllClients();
		log.info("::SERVICE:: TRANSFORM RESPONSE OF ALL CLIENTS");
		List<Client> response = transform.transformClientModelToClientService(modelResponse);
		log.info("::REPO:: RETRIEVING ALL CLIENTS");
		return response ;
	}

	public void createClient(Client request) {
			log.info("::POST:: SERVICE -> CREATE CLIENT REQUEST " + request );
			repo.createClient(transform.transformDoaminToModel(request));
	}

	@Override
	public Client findClientByName(String name) {
		log.info("::GET CLIENT BY NAME RUNNING RUNNING::");	
		ClientModel responseModel = repo.findClientByName(name);
		Client response = new Client();
		response.setName(responseModel.getName());
		response.setLastName(responseModel.getLastName());
		response.setAge(responseModel.getAge());
		response.setGender(responseModel.getGender());
		return response;
	}

}

