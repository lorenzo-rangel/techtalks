package com.globant.microservices.sample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globant.microservices.sample.model.User;

@Service
public interface IUserService {
	
	/**
	 * Returns user legalId when exists 
	 * @param username	The User user name
	 * @param password	The User password	
	 * @return			The legalID User
	 */
	public String getUserLegalId (String username, String password);

	/**
	 * Returns a users list
	 * @return 	A list crowded by users
	 */
	public List<User> getAllUsers();
}
;