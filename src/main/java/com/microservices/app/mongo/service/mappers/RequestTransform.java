package com.microservices.app.mongo.service.mappers;

import org.springframework.stereotype.Component;

import com.microservices.app.mongo.model.daos.ClientDao;
import com.microservices.app.mongo.model.domain.Client;

@Component
public class RequestTransform {
	public ClientDao transformDoaminToModel(Client clientRequest){
		
		ClientDao requestModel = new ClientDao();
		requestModel.setName(clientRequest.getName());
		requestModel.setLastName(clientRequest.getLastName());
		requestModel.setAge(clientRequest.getAge());
		requestModel.setGender(clientRequest.getGender());
		
		return requestModel;
	}
}
