package com.microservices.app.mongo.service.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.app.mongo.model.daos.ClientDao;
import com.microservices.app.mongo.model.domain.Client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseTransform {

	public List<Client> transformClientModelToClientService(List<ClientDao> responseModel) throws RuntimeException{
		log.info(" GET  ALL CLIENTS TRANSFORM RUNNING  PARAMETER RECEIVED  {}   " , responseModel);
			List<Client> response = new ArrayList<Client>();
			//Lambda Expresions 
			responseModel.stream().forEach(x -> { 
						Client client = new Client();
						if(x.getId()!=null && !x.getId().isEmpty()) {
							client.setId(x.getId());
				}
				client.setName(x.getName());
				client.setLastName(x.getLastName());
				client.setAge(x.getAge());
				client.setGender(x.getGender());
				response.add(client); } );
			log.info(" GET  ALL CLIENTS TRANSFORM RUNNING  RESPONSE  {}   " , response);
			return response;
	}
	
}
