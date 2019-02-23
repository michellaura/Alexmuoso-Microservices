package com.microservices.app.h2.exceptions.helpers;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DateHelper {

	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd";
	
	public void isDateValid(String dateFrom) throws InvalidParameterException {
		log.info(":::  isDateValid DATE HELPER  DATE {}" +  dateFrom);
		LocalDate today = LocalDate.now();
		log.info(":::  isDateValid TODAY  {}" +  today);
		LocalDate dateRequest = LocalDate.parse(dateFrom, formatter);
		if(today.compareTo(dateRequest) > 0) { 
			log.info(":::  isDateValid  : " +  today +" COMPARE TO " + dateFrom);
			throw new InvalidParameterException("Date must be equals to " + today.toString());
		}
	}
}

