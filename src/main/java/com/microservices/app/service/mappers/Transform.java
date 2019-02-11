package com.microservices.app.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import com.microservices.app.domain.Client;
import com.microservices.app.model.ClientModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Transform {

	
	public List<Client> transformClientModelToClientService(List<ClientModel> responseModel){
		log.info("::TRANSFORM::  TRANSFORM GET ALL CLIENTS");
		List<Client> response = new ArrayList<Client>();
		responseModel.stream().forEach(x -> { 
			Client client = new Client();
			client.setName(x.getName());
			client.setLastName(x.getLastName());
			client.setAge(x.getAge());
			client.setGender(x.getGender());
			response.add(client);});
		log.info("::TRANSFORM::  SUCCESS TRANSFORM GET ALL CLIENTS");
		return response;
	}
	
	public ClientModel transformDoaminToModel(Client clientRequest){
		
		ClientModel requestModel = new ClientModel();
		// ID
		requestModel.setId(StringUtils.randomAlphanumeric(10));   
		requestModel.setName(clientRequest.getName());
		requestModel.setLastName(clientRequest.getLastName());
		requestModel.setAge(clientRequest.getAge());
		requestModel.setGender(clientRequest.getGender());
		
		return requestModel;
	}
	
}
