package com.globant.microservices.sample.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	String id;
  	String firstName;
  	String lastName;
  	String legalId;
  	String username;
  	String password;
  	
  	
  
	public User() {
		super();
	}

	public User(String id, String firstName, String lastName, String legalId, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.legalId = legalId;
		this.username = username;
		this.password = password;
	}
	
	public User (String id, String username) {
		this(id, null, null, null, username, null);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLegalId() {
		return legalId;
	}
	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
  
  
  
  
  

}
