package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.UserModelDetails;
import com.user.service.UserService;
import com.user.util.UserConstant;


@RestController
@RequestMapping("userservice")
public class UserController {

	@Autowired
	UserService service;    

	
	
	@PostMapping(UserConstant.ENDPOINT_CREATE)
	public void createUsers(@Valid @RequestBody UserModelDetails details) {
		service.createUser(details);
	}
	

	
	
	@GetMapping(UserConstant.ENDPOINT_GETUSERS)
	public List<UserModelDetails> getAllUser() {
		List<UserModelDetails> user = service.getAllUsers();
		return user;
	}
	
    
	
	@GetMapping(UserConstant.ENDPOINT_GETDETAILSBYID)
	public ResponseEntity<UserModelDetails> getUserById(@PathVariable("userId") String userId) {
		System.out.println("Fetching user by userId " + userId);
		UserModelDetails details = service.findById(userId);
		if (details == null) {
			return new ResponseEntity<UserModelDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserModelDetails>(details, HttpStatus.OK);
	}
	
    
	
	@PutMapping(UserConstant.ENDPOINT_DELETEBYID)
	public String delete(@PathVariable("userId") String userId) {
		service.deleteUserById(userId);
		return "User Deleted";

	}

}
