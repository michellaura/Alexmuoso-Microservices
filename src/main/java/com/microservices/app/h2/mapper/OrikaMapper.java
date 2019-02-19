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
	
//	public MapperFactory mapProductDaoToProduct(MapperFactory factory) {
//		ConverterFactory convFact = factory.getConverterFactory();
//		convFact.registerConverter(new PassThroughConverter(LocalDate.class));
//	    factory.classMap(H2ClientDao.class, Product.class ).byDefault().register(); //.field("","")  .fieldMap TO DATES .byDefault() .Register();
//		return factory;
//	}
//	
//	public MapperFactory mapObjectToClient(MapperFactory factory) {
//	    factory.classMap(Object.class, Client.class ).byDefault().register(); //.field("","")  .fieldMap TO DATES .byDefault() .Register();
//		return factory;
//	}
//	
//	public MapperFactory mapObjectDaoToProduct(MapperFactory factory) {
//		ConverterFactory convFact = factory.getConverterFactory();
//		convFact.registerConverter(new PassThroughConverter(LocalDate.class));
//	    factory.classMap(Object.class, Product.class ).byDefault().register(); //.field("","")  .fieldMap TO DATES .byDefault() .Register();
//		return factory;
//	}
	
}
