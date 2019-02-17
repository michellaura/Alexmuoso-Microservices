package com.microservices.app.mongo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.app.mongo.model.ClientDao;

public interface ClientInterface extends MongoRepository<ClientDao, UUID> {
	
	
}
