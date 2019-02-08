package com.microservices.app.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.domain.Clients;
import com.microservices.app.model.ClientsModel;

@Component
public class Transform {

	
	public List<Clients> transformClientModelToClientService(List<ClientsModel> responseModel){
		List<Clients> response = new ArrayList<Clients>();
		responseModel.stream().forEach(x -> { 
			Clients client = new Clients();
			client.setName(x.getName());
			client.setLastName(x.getLastName());
			client.setAge(x.getAge());
			client.setSex(x.getSex());
			response.add(client);});
		return response;
	}
	
	public ClientsModel transformDoaminToModel(Clients clientRequest){
		
		ClientsModel requestModel = new ClientsModel();
		requestModel.setName(clientRequest.getName());
		requestModel.setLastName(clientRequest.getLastName());
		requestModel.setAge(clientRequest.getAge());
		requestModel.setSex(clientRequest.getSex());
		
		return requestModel;
	}
	
}
