package com.globant.microservices.sample.controller;

import com.globant.microservices.sample.model.User;
import com.globant.microservices.sample.repository.UserRepository;
import com.globant.microservices.sample.services.IUserService;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "User methods")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {

  @Autowired
  UserRepository userRepository;
  
  @Autowired
  IUserService userService;
  
  @RequestMapping("/greeting")
  @GetMapping
  public String greeting() {
	  return "Hello from my users app";
  }
  
  @RequestMapping("/users")
  @GetMapping
  public List<User> getAllUsers(){
	  return userService.getAllUsers();
  }
  
  @GetMapping("/finduserbyid/{id}")
  public ResponseEntity<User> findUserById(@PathVariable String id) {
	  System.out.println(id);
	  return ResponseEntity.of(userService.findUserById(id));
  }
  
  @GetMapping("/user/login/{username}/{password}")
  public String login(@PathVariable String username, @PathVariable String password) {
	 return userService.getUserLegalId(username, password);
  }
  
  @GetMapping("/user/{username}/{password}")
  public User findByUserNameAndPassword(@PathVariable String username, @PathVariable String password) {
	 return userService.findByUsernameAndPassword(username, password);
  }
  
  @GetMapping("/users/{legalId}")
  public List<User> findUsersByLegalId(@PathVariable String legalId) {
	  return userService.findUsersByLegalId(legalId);
  }

  @PostMapping("/user")
  public ResponseEntity<User> newUser(@RequestBody User user) {
	User u = userService.saveUser(user);
    return ResponseEntity.ok(u);
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
    User userUpdated = userRepository.findById(id).map(u -> {
      u.setFirstName(user.getFirstName());
      u.setLastName(user.getLastName());
      u.setLegalId(user.getLegalId());
      return userRepository.save(u);
    }).orElseGet(() -> {
      user.setId(id);
      return userRepository.save(user);
    });

    return ResponseEntity.ok(userUpdated);	
  }

  @DeleteMapping("/user/{id}")
  public void deleteUser(@PathVariable String id) {
    userRepository.deleteById(id);
  }
}