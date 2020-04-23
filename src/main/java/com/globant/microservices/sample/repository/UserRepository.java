package com.globant.microservices.sample.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.globant.microservices.sample.model.User;

@Repository
public class UserRepository {

@SuppressWarnings({ "unchecked", "rawtypes" })
private static Map<String, User> users = new HashMap();

  public Optional<User> findById(String id) {
    return Optional.ofNullable(users.get(id));
  }

  public User save(User user) {
    users.put(user.getId(), user);
    return user;
  }

  public void deleteById(String id) {
    users.keySet().removeIf(key -> key.equals(id));
  }
  
  public String getUserLegalId(String username, String password) {
	  return users.entrySet().stream()
			  .map(user -> user.getValue())
			  .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
			  .map(user -> user.getLegalId()).collect(Collectors.joining());
  }
  
  public List<User> getAllUsers() {
	  return users.values().stream().collect(Collectors.toList());
	  
  }
  
  
}
