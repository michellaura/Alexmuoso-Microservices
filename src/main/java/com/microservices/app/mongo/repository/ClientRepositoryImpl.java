package com.microservices.app.mongo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.app.mongo.model.ClientDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientRepositoryImpl {

	@SuppressWarnings("rawtypes")
	@Autowired
	private MongoRepository repoMongoCrud;
	@Autowired
	private ClientRepository clientRepository;

	@SuppressWarnings("unchecked")
	public List<ClientDao> getAllClients() {
		log.info("::GET getAllClients :: REPOSITORY  CALLING MONGO CLUSTER :::");
		List<ClientDao> daoResponse = new ArrayList<ClientDao>();
		daoResponse = repoMongoCrud.findAll();
		log.info("::GET getAllClients :: REPOSITORY  RESPONSE ::: {}", daoResponse);
		return daoResponse;
	}

	@SuppressWarnings("unchecked")
	public void createClient(ClientDao requestModel) {
		log.info("::POST createClient :: REPOSITORY  CALLING MONGO CLUSTER :::");
		repoMongoCrud.insert(requestModel);
	}

	public List<ClientDao> getAllClientsByName(String name) {
		log.info("::GET getByName :: REPOSITORY  CALLING MONGO CLUSTER :::");
		return clientRepository.findByName(name);
	}

}
