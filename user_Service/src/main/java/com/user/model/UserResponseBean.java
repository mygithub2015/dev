package com.user.model;

import java.util.List;

public class UserResponseBean {
	
	private String status_Code;
	private String message;
	private List<UserModelBean> userList;
	public UserResponseBean(){
	super();
	}
	public UserResponseBean(String status_Code, String message, List<UserModelBean> userList) {
		super();
		this.status_Code = status_Code;
		this.message = message;
		this.userList = userList;
	}
	public String getStatus_Code() {
		return status_Code;
	}
	public void setStatus_Code(String status_Code) {
		this.status_Code = status_Code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserModelBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserModelBean> userList) {
		this.userList = userList;
	}

}
