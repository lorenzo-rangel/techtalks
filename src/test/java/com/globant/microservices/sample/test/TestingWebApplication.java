package com.globant.microservices.sample.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.globant.microservices.sample.controller.UsersController;

/**
 * Simple sanity check test that will fail if the application context cannot start. T
 * @author lorenzo.rangel
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestingWebApplication {
	
	@Autowired
	private UsersController userController;
	
	/**
	 * The @SpringBootTest annotation tells Spring Boot to look for a main configuration class 
	 * (one with @SpringBootApplication, for instance) and use that to start a Spring application context. 
	 */
	@Test
	public void contextLoads() {
	}
	
	/**
	 * Assertion to convince that the context is creating usersController 
	 * @throws Exception	Exception in case context is not creating the controller
	 */
	@Test
	public void userContextLoads() throws Exception{
		assertThat(userController).isNotNull();
	}

}
