package com.globant.microservices.sample.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	private TestRestTemplate testRestTemplate;
	
	/**
	 * Greeting end point testing
	 * @throws Exception
	 */
	@Test
	public void greetinShoudReturnMessage() throws Exception{
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/greeting", String.class))
		.contains("Hello from my users app");
	}
	
	/**
	 * Tests end point that should return one user object when username and password match with the user in DB
	 * @throws Exception
	 */
	@Test
	public void getUserByUserAndPasswordShouldReturnUser() throws Exception{
		User user = new User("unit123","UnitTest","Java","unit123","tester","1234");
		User userFromHttpRequest = this.testRestTemplate.getForObject("http://localhost:" + port + "/user/"+user.getUsername()+"/"+user.getPassword(), User.class);
				
		assertThat(userFromHttpRequest).isEqualToComparingFieldByField(user);
	}
	
	/**
	 * Tests size of some users list
	 * @throws Exception
	 */
	@Test 
	public void getUsersListSizeShouldBe() throws Exception{
		int correctSize = 1;
		ResponseEntity<User[]> responseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/users/unit123", User[].class);
		User[] users = responseEntity.getBody();
		assertTrue(correctSize == users.length);
	}
	
	
	/**
	 * Tests the same user object returned after being added to data base
	 * @throws Exception
	 */
	@Test 
	public void getUserShouldBeAfterAdded() throws Exception{
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    JSONObject userJsonObject = new JSONObject();
	    
	    userJsonObject.put("id", "test1234");
	    userJsonObject.put("firstName", "UnitTestName");
	    userJsonObject.put("lastName", "UnitTestLastname");
	    userJsonObject.put("legalId", "UNIT20200413");
	    userJsonObject.put("username", "unittester");
	    userJsonObject.put("password", "1234");
	    
	    HttpEntity<String> request = new HttpEntity<String>(userJsonObject.toString(), headers);
	    
	   User userFromHttpRequest = this.testRestTemplate.postForObject("http://localhost:" + port + "/user", request, User.class);
		ObjectMapper objectMapper = new ObjectMapper();
		assertThat(userFromHttpRequest).isEqualToComparingFieldByField	(objectMapper.readValue(userJsonObject.toString(), User.class));
		
	}
	
	
	
	//before
	
	

}
