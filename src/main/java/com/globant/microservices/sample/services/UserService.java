package com.globant.microservices.sample.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.microservices.sample.model.User;
import com.globant.microservices.sample.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired 
	IUserRepository iUserRepository;

	@Override
	
	public String getUserLegalId(String username, String password) {
		//return userRepository.getUserLegalId(username, password).length() > 0 ? userRepository.getUserLegalId(username, password) : null;
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return iUserRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		if(user.getId() == null) {
	      user.setId(UUID.randomUUID().toString());
	    }
	    return iUserRepository.save(user);
	}

	@Override
	public User findByUsernameAndPassword(String userName, String password) {
		return iUserRepository.findByUsernameAndPassword(userName, password);
	}

	@Override
	public List<User> findUsersByLegalId(String legalId) {
		return iUserRepository.findUsersByLegalId(legalId);
	}

	@Override
	public Optional<User> findUserById(String id) {
		return iUserRepository.findById(id);
	}

	

	
	
	
	
	
	

}
