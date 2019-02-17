package com.microservices.app.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.model.ClientDao;
import com.microservices.app.mongo.repository.ClientRepositoryImpl;
import com.microservices.app.mongo.service.mappers.RequestTransform;
import com.microservices.app.mongo.service.mappers.ResponseTransform;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepositoryImpl repo;
	@Autowired
	ResponseTransform responseTransform;
	@Autowired
	RequestTransform requestTransform;

	@Override
	public List<Client> getAllClients() {
		log.info("::GET getAllClients  SERVICE :: CALL REPO  ");
		List<ClientDao> modelResponse = repo.getAllClients();

		log.info("::GET getAllClients  SERVICE :: MAPPING DAO TO RESPONSE  ");
		List<Client> response = responseTransform.transformClientModelToClientService(modelResponse);

		log.info("::GET getAllClients  SERVICE :: RESPONSE {}  ", response);
		return response;
	}

	@Override
	public void createClient(Client request) {
		log.info("::POST createClient  SERVICE ::  Transform Request ");
		ClientDao requestDao = requestTransform.transformDoaminToModel(request);

		log.info("::POST createClient  SERVICE ::  Calling Repository ");
		repo.createClient(requestDao);
	}

	@Override
	public List<Client>getAllClientsByName(String name) throws RuntimeException	{
			log.info("::GET getByName  SERVICE :: CALL REPO  ");
			List<ClientDao> daoResponse = repo.getAllClientsByName(name);

			log.info("::GET getByName  SERVICE ::  MAPPING RESPONSE DAO TO RESPONSE");
			List<Client> response = responseTransform.transformClientModelToClientService(daoResponse);
			if(response.isEmpty()) { throw new RuntimeException() ; }
			log.info("::GET getByName  SERVICE :: RESPONSE {}  ", response);

		return response;
	}

}
