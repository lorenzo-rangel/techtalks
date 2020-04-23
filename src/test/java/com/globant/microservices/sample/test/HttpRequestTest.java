package com.globant.microservices.sample.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.globant.microservices.sample.model.User;


/**
 * 
 * @author lorenzo.rangel
 * webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments)
 * Resource at https://spring.io/guides/gs/testing-web/
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
	/**
	 * Injection of the port with @LocalServerPort. 
	 */
	@LocalServerPort
	private int port;
	
	/**
	 * Spring Boot has automatically provided a TestRestTemplate. All is required to do is add @Autowired to it.
	 */
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void greetinShoudReturnMessage() throws Exception{
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
		.contains("Hello from my users app");
	}
	
	
	@Test
	public void getUserByUserAndPasswordShouldReturnUser() throws Exception{
		User user = new User("unit123","UnitTest","Java","unit123","tester","1234");
		User userFromHttpRequest = this.restTemplate.getForObject("http://localhost:" + port + "/user/"+user.getUsername()+"/"+user.getPassword(), User.class);
				
		assertThat(userFromHttpRequest).isEqualToComparingFieldByField(user);
	}
	
	
	@Test 
	public void getUsersListSizeShouldBe() throws Exception{
		int correctSize = 2;
		ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/users/unit123", User[].class);
		User[] users = responseEntity.getBody();
		assertTrue(correctSize == users.length);
	}
	
	

}
