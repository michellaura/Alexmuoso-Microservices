package com.microservices.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservices.app.model.ClientsModel;
import com.mongodb.MongoException;

@Repository
public class ClientRepositoryImpl {

	@Autowired
	private ClientInterface clienteInterface;

	/*
	 * This Repository Method will go to the MOngo DB and take all the Clients in
	 * Docs.
	 */
	public List<ClientsModel> getAllClients(){
		try {
			List<ClientsModel> responseModel =clienteInterface.findAll();
			if (responseModel.size() == 0) {// Validate response
				 throw new MongoException("ERROR IN DB");
			}
		}catch(MongoException exMongo){
				throw new MongoException("ERROR IN DB");
		}
		return clienteInterface.findAll();
	}
}
