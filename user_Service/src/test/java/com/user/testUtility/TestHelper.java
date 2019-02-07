package com.user.testUtility;

import java.util.ArrayList;
import java.util.List;

import com.user.model.UserModelBean;
import com.user.model.UserModelEntity;

public class TestHelper {

	public static UserModelEntity getEntityObj() {
		UserModelEntity userModelEntity=new UserModelEntity("1", "Password", "Surya", "Surya@email.com", "8989898989", "Admin", "Deleted");
		return userModelEntity;
	}
	
	public static UserModelBean getBeanObj(){
		UserModelBean userModelBean=new UserModelBean("1", "Password", "Surya", "Surya@email.com", "8989898989", "Admin");
		return userModelBean;
	}
	
	public static List<UserModelEntity> getEntitylist(){
		List<UserModelEntity> list=new ArrayList<>();
		UserModelEntity userModelEntity1=new UserModelEntity("1", "Password", "Surya", "Surya@email.com", "8989898989", "Admin","Deleted");
		list.add(userModelEntity1);
		return list;
	}
	 

}
