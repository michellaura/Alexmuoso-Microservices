package com.microservices.app.h2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;

@Component
public interface H2ClientRepository extends CrudRepository<H2ClientDao, Long>{

}
