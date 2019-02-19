package com.microservices.app.h2.service.mapper;

import org.springframework.stereotype.Component;

import com.microservices.app.h2.daos.H2ClientDao;
import com.microservices.app.h2.domain.Client;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class MapperClients extends ConfigurableMapper{

	public MapperFactory getAllClientsMapper(MapperFactory factory) {

//|		ConverterFactory convFact = factory.getConverterFactory();
//		convFact.registerConverter(new PassThroughConverter(LocalDateTime.class));
	
	    factory.classMap(H2ClientDao.class, Client.class ).byDefault().register(); //.field("","")  .fieldMap TO DATES .byDefault() .Register();
	
	
	
		return factory;
	}
	
	
	
}
