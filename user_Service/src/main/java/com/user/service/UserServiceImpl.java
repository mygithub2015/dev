package com.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.model.UserModelEntity;
import com.user.model.UserModelBean;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserModelBean createUser(UserModelBean userDetails) {
		ObjectMapper mapper = new ObjectMapper();
 		UserModelEntity userModel = mapper.convertValue(userDetails, UserModelEntity.class);
 		return mapper.convertValue(userRepo.save(userModel), UserModelBean.class);
 		
	}
 

	

	@Override
	public List<UserModelBean> getAllUsers() {
		List<UserModelBean> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (UserModelEntity temp : userRepo.findAll()) {
			UserModelBean details = mapper.convertValue(temp, UserModelBean.class);
			list.add(details);

		}
		return list;

	}

	@Transactional
	@Override
	public int deleteUserById(String userId) {
		userRepo.updateDeleteFlag(userId);

	}
	
	@Transactional
	@Override
	public void updateUser(UserModelBean userDetails, String userId) {
		UserModelBean userModelDetails = new UserModelBean();
		ObjectMapper mapper = new ObjectMapper();
		UserModelEntity userModel = mapper.convertValue(userDetails, UserModelEntity.class);
		userRepo.updateUser(userId, userDetails.getUserName(), userDetails.getUserPassword(), userDetails.getUserEmail(), userDetails.getUserMobile(), userDetails.getUserRole());
	}

	@Override
	public UserModelBean findById(String userId) {
		ObjectMapper mapper = new ObjectMapper();
		UserModelBean details = mapper.convertValue(userRepo.findOne(userId), UserModelBean.class);
		return details;
	}

}
