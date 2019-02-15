package com.microservices.app.mongo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.app.mongo.model.ClientModel;
import com.mongodb.MongoException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class ClientRepositoryImpl{

	@Autowired
	private ClientRepositoryCrud mongoRepo;

	public List<ClientModel> getAllClients(){
		log.info("::REPO:: GET ALL CLIENTS RUNNING");
		List<ClientModel> responseModel = new ArrayList<ClientModel>() ;
		responseModel = mongoRepo.findAll();
		log.info("::REPO:: REPONSE ALL CLIENTS  " + responseModel );
		log.info("::REPO:: RETRIEVING ALL CLIENTS");
		return responseModel;
	}

	public void createClient(ClientModel requestModel) {
		
		log.info("::POST:: REPO -> INSERT CLIENT DATA {}" , requestModel);
		try {
			mongoRepo.insert(requestModel);
		}catch( MongoException e) {
			log.info(e.getLocalizedMessage());
			throw e;
		}
	}
	
	public ClientModel findClientByName(String name) {
		return mongoRepo.findByName(name);
	}
}