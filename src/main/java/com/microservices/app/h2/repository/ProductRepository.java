package com.microservices.app.h2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.ProductDao;

@Component
public interface ProductRepository  extends CrudRepository<ProductDao, Long>{
	
	
	@Query(value="SELECT * FROM PRODUCTS  WHERE  CREATE_AT > :dateFrom " , nativeQuery= true)
	public List<ProductDao> getAllProductsByDate(@Param("dateFrom") String dateFrom);
	
	
	
}