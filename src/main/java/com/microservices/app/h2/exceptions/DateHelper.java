package com.microservices.app.h2.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DateHelper {

	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final String JSON_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MIN_DATE = "2019-01-01";
	
	public  void isDateValid(String dateFrom , StringBuffer exceptionMessage ) {
		log.info("::: DATE HELPER  DATE {} " +  dateFrom);
		try {
	        LocalDate dateMinRequiered = LocalDate.parse(MIN_DATE, formatter);
	        LocalDate dateRequest = LocalDate.parse(dateFrom, formatter);
	        if( dateMinRequiered.compareTo(dateRequest) > 0 ) {
	        	exceptionMessage.append("Date : " + dateFrom + " is invalid ");
	        }
		}catch(DateTimeParseException dexc) {
			log.info("::: DATE HELPER isDateValid ERROR " +  dexc.getMessage() );
		}
	}
	
}
