package com.globant.microservices.sample.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.microservices.sample.model.User;
import com.globant.microservices.sample.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public String getUserLegalId(String username, String password) {
		return userRepository.getUserLegalId(username, password).length() > 0 ? userRepository.getUserLegalId(username, password) : null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User(UUID.randomUUID().toString(), "aperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "bperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "cperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "dperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "eperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "fperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "gperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "hperez"));
		usersList.add(new User(UUID.randomUUID().toString(), "iperez"));
		return usersList;
	}
	
	
	
	
	

}
