package com.globant.microservices.sample.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.globant.microservices.sample.controller.UsersController;
import com.globant.microservices.sample.services.IUserService;

@WebMvcTest(UsersController.class)
public class ServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IUserService iUserService;
	
	/**
	 * Test class and its method on the services layer just a simple string return
	 * @throws Exception
	 */
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception{
		
		when(iUserService.testGreeting()).thenReturn("Greetings!");
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Greetings!"));
		
	}

}