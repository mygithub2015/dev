package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value="/saveUser")
	public User createUser(@RequestBody User user){
		User user1=userService.createUser(user);
		return user1;

	}

	@GetMapping(value="/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id){
		return new ResponseEntity<User>(userService.findById(id),HttpStatus.OK);
	}
}