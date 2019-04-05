package com.notice.model;

import java.util.List;

import com.notice.entity.NoticeModelEntity;

public class NoticeResponseBean {
	private String status_Code;
	private String message;
	private List<NoticeModelEntity> userList;
	
	public NoticeResponseBean(){
		
	}

	public NoticeResponseBean(String status_Code, String message, List<NoticeModelEntity> userList) {
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

	public List<NoticeModelEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<NoticeModelEntity> userList) {
		this.userList = userList;
	}
	
}
