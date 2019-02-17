package com.microservices.app.mongo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.app.mongo.model.ClientDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ClientRepositoryImpl {

	@Autowired
	private ClientInterface repoMongoCrud;

	public List<ClientDao> getAllClients(){
		log.info("::GET getAllClients :: REPOSITORY  CALLING MONGO CLUSTER :::");
		List<ClientDao> daoResponse = new ArrayList<ClientDao>() ;
		daoResponse = repoMongoCrud.findAll();
		log.info("::GET getAllClients :: REPOSITORY  RESPONSE ::: {}" , daoResponse);
		return daoResponse;
	}
	public void createClient(ClientDao requestModel) {
		log.info("::POST createClient :: REPOSITORY  CALLING MONGO CLUSTER :::");
		repoMongoCrud.insert(requestModel);
	}
}
