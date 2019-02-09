package com.microservices.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microservices.app.model.ClientModel;

@Repository
public class ClientRepositoryImpl{

	@Autowired
	private ClientRepositoryCrud mongoRepo;

	public List<ClientModel> getAllClients(){
		List<ClientModel> responseModel = new ArrayList<ClientModel>() ;
		responseModel = mongoRepo.findAll();
		return responseModel;
	}

	public void createClient(ClientModel requestModel) {
		mongoRepo.insert(requestModel);
	}
	
	public ClientModel findClientByName(String name) {
		return mongoRepo.findByName(name);
	}
}
