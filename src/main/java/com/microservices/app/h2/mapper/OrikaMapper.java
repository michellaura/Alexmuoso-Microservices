package com.microservices.app.h2.mapper;


import org.springframework.stereotype.Component;

import com.microservices.app.h2.model.daos.H2ClientDao;
import com.microservices.app.h2.model.domain.Client;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class OrikaMapper extends ConfigurableMapper{

	
	public MapperFactory mappClientDaoToClient(MapperFactory factory) {
	    factory.classMap(H2ClientDao.class, Client.class ).byDefault().register(); //.field("","")  .fieldMap TO DATES .byDefault() .Register();
		return factory;
	}
}
