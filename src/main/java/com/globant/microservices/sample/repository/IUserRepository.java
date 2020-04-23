package com.globant.microservices.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.globant.microservices.sample.model.User;

@Repository
public interface IUserRepository extends JpaRepository <User, String>{
	
	/**
	 * Find an User by his/her username and password
	 * @param userName		the User username
	 * @param password		The User password 
	 * @return				The User found by username and password
	 */
	User findByUsernameAndPassword(String username, String password);
	
	/**
	 * Find an User by his/her legalId
	 * @param legalId		the User legalId
	 * @return				The User list found by his or her legalId
	 */
	@Query("select u from User u where u.legalId like %?1%")
	List<User> findUsersByLegalId(String legalId);
	
	
	

}
