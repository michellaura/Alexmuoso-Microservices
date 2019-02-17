package com.microservices.app.mongo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.app.mongo.model.ClientDao;

@Repository
public interface ClientRepository extends MongoRepository<ClientDao, UUID> {
	
	ClientDao findByName(String name) ;
}
