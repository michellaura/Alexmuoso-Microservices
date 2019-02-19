package com.microservices.app.h2.service;

import java.util.List;

import com.microservices.app.h2.domain.Client;

public interface H2ClientService {

	public List<Client> getAllClients();
}
