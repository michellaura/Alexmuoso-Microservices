package com.microservices.app.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.app.model.ClientsModel;

@Repository
public interface ClientInterface extends MongoRepository<ClientsModel, UUID> {
}
