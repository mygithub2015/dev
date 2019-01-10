package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.user.exception.UserCustomException;
import com.user.model.UserModelBean;
import com.user.model.UserResponseBean;
import com.user.service.UserService;
import com.user.util.UserConstant;


/** 
 * UserController is responsible for all end-point related to user service
 * @author 700537
 *
 */

@RestController
@RequestMapping("userservice")
public class UserController {

	@Autowired
	UserService service;  
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	/**
	 * End-point to create new user
	 * @param UserModelBean details
	 * @return UserResponseBean
	 * @throws UserCustomException 
	 */
	@PostMapping(UserConstant.ENDPOINT_CREATE)
	public UserResponseBean createUsers(@Valid @RequestBody UserModelBean details) throws UserCustomException {
		UserResponseBean responseBean= new UserResponseBean();
		List<UserModelBean> userList=new ArrayList<>();
		details=service.createUser(details);
		if(details!=null){
			userList.add(details);
			responseBean.setStatus_Code(UserConstant.STATUS_CODE);
			responseBean.setMessage(UserConstant.MESSAGE);
			responseBean.setUserList(userList);
			logger.info(UserConstant.SUCCESS);
		}else{
			logger.error(UserConstant.ERROR_CODE);
			throw new UserCustomException("Record is not found");
		}
		return responseBean;
	}
	
	
	/**
	 * End-point to get all details of userService
	 * @return UserModelBean list
	 */
	@GetMapping(UserConstant.ENDPOINT_GETUSERS)
	public List<UserModelBean> getAllUser() {
		List<UserModelBean> user = service.getAllUsers();
		if(!user.isEmpty()){
			logger.info(UserConstant.SUCCESS);
			
		}else{
			logger.error(UserConstant.ERROR_CODE);
			throw new UserCustomException("Record is not found");
		}
		return user;
	}
	
    
	/**
	 * End-point to get user by ID
	 * @param userId
	 * @return UserModelBean ResponseEntity
	 * @throws UserCustomException 
	 */
	@GetMapping(UserConstant.ENDPOINT_GETDETAILSBYID)
	public ResponseEntity<UserModelBean> getUserById(@PathVariable("userId") String userId) throws UserCustomException {
		System.out.println("Fetching user by userId " + userId);
		UserModelBean details = service.findById(userId);
		if (details == null) {
			throw new UserCustomException(UserConstant.ERROR_CODE);
		}
		return new ResponseEntity<UserModelBean>(details, HttpStatus.OK);
	}
	
	
	/**
	 * End-Point to delete user by userId
	 * @param String userId
	 * @return String
	 */
	@PutMapping(UserConstant.ENDPOINT_DELETEBYID)
	public String delete(@PathVariable("userId") String userId) {
		service.deleteUserById(userId);
		return "User Deleted";

	}
	
	@PutMapping(UserConstant.ENDPOINT_UPDATE)
	public void updateUser(@RequestBody UserModelBean userBean,@PathVariable("userId") String userId){
		service.updateUser(userBean, userId);
		logger.info(UserConstant.SUCCESS);
	}

}
