package com.microservices.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microservices.app.model.ClientsModel;

@Repository
public class ClientRepositoryImpl {

	@Autowired
	private ClientInterface repoMongoCrud;

	/*
	 * This Repository Method will go to the MOngo DB and take all the Clients in
	 * Docs.
	 */
	public List<ClientsModel> getAllClients(){
		List<ClientsModel> responseModel = new ArrayList<ClientsModel>() ;
		responseModel = repoMongoCrud.findAll();
		return responseModel;
	}
	/*
	 * This Repository Method will go to the MOngo DB and insert Clients in
	 * Docs.
	 */
	public void createClient(ClientsModel requestModel) {
		repoMongoCrud.insert(requestModel);
	}
}
