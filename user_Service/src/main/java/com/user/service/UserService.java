package com.user.service;

import java.util.List;

import com.user.model.UserModelBean;

/**
 * This is abstraction interface for service implementation class
 * @author 700537
 *
 */
public interface UserService {

	/**
	 * Method to create new user
	 * @param UserModelBean userDetails
	 * @return UserModelBean userModelBean
	 */
	public UserModelBean createUser(UserModelBean userDetails);

	/**
	 * Method to get all user details
	 * @return List<UserModelBean> modelList
	 */
	public List<UserModelBean> getAllUsers();

	/**
	 * Method to delete user record by id
	 * @param String userId
	 */
	public void deleteUserById(String userId);

	/**
	 * Method to update user
	 * @param UserModelBean userDetails
	 * @param String userId
	 */
	public void updateUser(UserModelBean userDetails,String userId);
	
	/**
	 * Method to return user data by selected userId
	 * @param String userId
	 * @return UserModelBean userModelBean
	 */
	public UserModelBean findById(String userId);

}
