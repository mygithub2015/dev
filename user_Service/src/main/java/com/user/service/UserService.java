package com.user.service;

import java.util.List;

import com.user.model.UserModelDetails;

public interface UserService {

	public void createUser(UserModelDetails userDetails);

	public List<UserModelDetails> getAllUsers();

	public void deleteUserById(String userId);

	public UserModelDetails updateUser(UserModelDetails userDetails,String l);
	
	public UserModelDetails findById(String userId);

}
