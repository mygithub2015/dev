package com.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.model.UserModel;
import com.user.model.UserModelDetails;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public void createUser(UserModelDetails userDetails) {
		ObjectMapper mapper = new ObjectMapper();
 		UserModel userModel = mapper.convertValue(userDetails, UserModel.class);
		userRepo.save(userModel);

	}

	@Override
	public List<UserModelDetails> getAllUsers() {
		List<UserModelDetails> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		for (UserModel temp : userRepo.findAll()) {
			UserModelDetails details = mapper.convertValue(temp, UserModelDetails.class);
			list.add(details);

		}
		return list;

	}

	@Transactional
	@Override
	public void deleteUserById(String userId) {
		userRepo.updateDeleteFlag(userId);

	}

	@Override
	public UserModelDetails updateUser(UserModelDetails userDetails, String l) {
		UserModelDetails userModelDetails = new UserModelDetails();
		ObjectMapper mapper = new ObjectMapper();
		UserModel userModel = mapper.convertValue(userDetails, UserModel.class);
		userModelDetails = mapper.convertValue(userRepo.save(userModel), UserModelDetails.class);
		return userModelDetails;
	}

	@Override
	public UserModelDetails findById(String userId) {
		ObjectMapper mapper = new ObjectMapper();
		UserModelDetails details = mapper.convertValue(userRepo.findOne(userId), UserModelDetails.class);
		return details;
	}

}
