package com.microservices.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.app.domain.Clients;
import com.microservices.app.model.ClientsModel;
import com.microservices.app.repository.ClientRepositoryImpl;
import com.mongodb.MongoException;

@Service
public class ClientService {

	private static final Logger LETSLOGG = LoggerFactory.getLogger(ClientService.class);// TO runtime loggs

	@Autowired // Initializing Repository
	ClientRepositoryImpl repo;

	@SuppressWarnings("unchecked")
	public List<Clients> getAllClients() {
		LETSLOGG.info("Service getAllClients Running ");
		List<ClientsModel> modelResponse = new ArrayList<ClientsModel>();
		List<Clients> response = new ArrayList<Clients>();
		Clients client = new Clients();
		try {
			LETSLOGG.info("Mapping reponse");

			modelResponse = repo.getAllClients();// Calling repository crud interface

			modelResponse.stream().forEach(x -> {
				client.setName(x.getName());
				client.setLastName(x.getLastName());
				client.setAge(x.getAge());
				client.setSex(x.getSex());
				response.add(client);
			});
		} catch (MongoException exMongo) {
			LETSLOGG.info("Something was wrong in repository");
			return (List<Clients>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ErrorZaso brother");
		}
		return response;// Response Data
	}

}
