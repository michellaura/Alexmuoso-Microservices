package com.microservices.app.h2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.app.h2.daos.H2ClientDao;
import com.microservices.app.h2.domain.Client;
import com.microservices.app.h2.repository.H2ClientRepositoryImpl;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

@Slf4j
@Service
public class H2ClientServiceImpl implements H2ClientService {

	@Autowired
	private	H2ClientRepositoryImpl repo;
	private MapperFacade facade;
	
	@Override
	@Transactional(readOnly = true)
	public List<Client> getAllClients() {
		log.info(":: GET  SERVICE :: RUNNING");
		List<H2ClientDao> reponseDao = repo.getAllClients();
		List<Client> response = new ArrayList<Client>();

		reponseDao.stream().forEach((clientDao) -> {

			response.add(facade.map(clientDao, Client.class));

		});

		log.info(":: GET  SERVICE :: RETURN RESPONSE  {}", response);
		return response;
	}
	
}
