package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user.util.UserConstant;

@Entity
@Table(name = "userModel")
public class UserModelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = UserConstant.USER_ID)
	private String userId;
	
	@Column(name = UserConstant.USER_PASSWORD)
	private String userPassword;
    
	@Column(name = UserConstant.USER_NAME)
	private String userName;
    
	@Column(name = UserConstant.USER_EMAIL)
	private String userEmail;
    
	@Column(name = UserConstant.USER_MOBILE)
	private String userMobile;

	@Column(name = UserConstant.USER_ROLE)
	private String userRole;
	
	@JsonIgnore
	@Column(name= UserConstant.USER_STATUS , columnDefinition="Varchar2(5) default 'N'")
	private String userStatus="N";


	public UserModelEntity() {

	}


	public UserModelEntity(String userId, String userPassword, String userName, String userEmail, String userMobile,
			String userRole, String userStatus) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userRole = userRole;
		this.userStatus = userStatus;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserMobile() {
		return userMobile;
	}


	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userMobile=" + userMobile + ", userRole=" + userRole + ", userStatus="
				+ userStatus + "]";
	}


}
