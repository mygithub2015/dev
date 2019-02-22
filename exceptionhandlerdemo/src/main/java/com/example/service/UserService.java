package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.userexception.UserCustomException;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	public User createUser(User user)
	{
		if(user.getName().length()<10){
			return userRepository.save(user);
		}else{
			throw new UserCustomException("Name Should not be grater than 10 character");
		}
	}
	public User findById(String id)
	{
		User user=null;
		Optional<?> opUser=userRepository.findById(id);
		if(opUser.isPresent()){
			user=(User) opUser.get();
		}else{
			throw new UserCustomException("Record Is Not Found");
		}
		return user;
	}
}
