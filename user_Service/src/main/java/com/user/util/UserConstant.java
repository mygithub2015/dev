package com.user.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserConstant {
	public static final String ENDPOINT_CREATE = "/save";
	public static final String ENDPOINT_GETUSERS = "/get";
	public static final String ENDPOINT_GETDETAILSBYID = "/userid/{userId}";
	public static final String ENDPOINT_DELETEBYID = "/delete/{userId}";
	public static final String ENDPOINT_UPDATE="/update/{userId}";
	
	
	public static final String USER_ID="user_Id";
	public static final String USER_PASSWORD="user_Password";
	public static final String USER_NAME="user_Name";
	public static final String USER_EMAIL="user_Email";
	public static final String USER_MOBILE="user_Mobile";
	public static final String USER_ROLE="user_Role";
	public static final String USER_STATUS="user_Status";
	
	public static final String STATUS_CODE="200";
    public static final String MESSAGE="Your Record Is Successfully Created";
    
    public static final String SUCCESS="Successful";
    public static final String ERROR_MESG="Record Not Found";
    
    public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json")); 
	
}