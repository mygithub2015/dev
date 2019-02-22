package com.example.userexception;

@SuppressWarnings("serial")
public class UserCustomException extends RuntimeException {
	public UserCustomException(String msg){
		super(msg);
	}

}
