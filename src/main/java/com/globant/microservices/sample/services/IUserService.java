package com.globant.microservices.sample.services;

import java.util.List;
import java.util.Optional;

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
	
	/**
	 * Add an User to the Database
	 * @param user	The User that will be stored in the database
	 * @return		User that was stored in the DB
	 */
	public User saveUser(User user);
	
	
	/**
	 * Find an User by his/her username and password
	 * @param userName		the User username
	 * @param password		The User password 
	 * @return				The User found by username and password
	 */
	public User findByUsernameAndPassword(String userName, String password);
	
	
	/**
	 * Find an User by his/her legalId
	 * @param legalId		the User legalId
	 * @return				The User list found by his or her legalId
	 */
	public List<User> findUsersByLegalId(String legalId);
	
	
	/**
	 * Find an User by his/her Id
	 * @param legalId		the User Id
	 * @return				The User list found by his or her Id
	 */
	public  Optional<User> findUserById(String id);
	
	
	/**
	 * For testing purposes
	 * @return String greeting
	 */
	public String testGreeting();
	
}
