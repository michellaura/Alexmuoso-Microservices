package com.microservices.app.mongo.service.mappers;

import org.springframework.stereotype.Component;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.model.ClientDao;

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
