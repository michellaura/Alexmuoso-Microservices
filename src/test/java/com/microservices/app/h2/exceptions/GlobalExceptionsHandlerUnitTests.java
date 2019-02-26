package com.microservices.app.h2.exceptions;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class GlobalExceptionsHandlerUnitTests {

	private GlobalExceptionsHandler globalExceptionsHandler;
	
	@Before
	public void setup() {
		
	}
	
	@Test()
	public void test_invalidParameterException() {
		Error error = globalExceptionsHandler.invalidParameterException(new InvalidParameterException("jeje") );
		assertEquals("400", error.getCode().toString());
	}
}
