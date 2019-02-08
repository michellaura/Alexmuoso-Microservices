package com.microservices.app.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.app.model.ClientsModel;

public interface ClientInterface extends MongoRepository<ClientsModel, UUID> {
	
	
}
