package com.microservices.app.mongo.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.mongo.domain.Client;
import com.microservices.app.mongo.model.ClientDao;

@Component
public class ResponseTransform {

	
	public List<Client> transformClientModelToClientService(List<ClientDao> responseModel){
		List<Client> response = new ArrayList<Client>();
		responseModel.stream().forEach(x -> { 
			Client client = new Client();
			client.setName(x.getName());
			client.setLastName(x.getLastName());
			client.setAge(x.getAge());
			client.setGender(x.getGender());
			response.add(client);});
		return response;
	}
	
}
