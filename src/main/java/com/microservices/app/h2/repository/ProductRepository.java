package com.microservices.app.h2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.ProductDao;

@Component
public interface ProductRepository  extends CrudRepository<ProductDao, Long>{
	
	
}