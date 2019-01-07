package com.user.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.model.UserModelEntity;


@Repository
public interface UserRepository extends JpaRepository<UserModelEntity, String> {
   
	@Modifying
	@Query("UPDATE UserModelEntity p SET p.userStatus  = 'Y' WHERE p.userId = :userId") 
	void updateDeleteFlag(@Param("userId") String userId);
	
	@Modifying
	@Query("UPDATE UserModelEntity p SET p.userName  = :userName ,p.userPassword  = :userPassword ,p.userEmail  = :userEmail ,p.userMobile  = :userMobile,p.userRole  = :userRole  WHERE p.userId = :userId") 
	void updateUser(@Param("userId") String userId,@Param("userName") String userName,@Param("userPassword") String userPassword,@Param("userEmail") String userEmail,@Param("userMobile") String userMobile,@Param("userRole") String userRole);
	
	
	
	@Override
	@Query("SELECT p FROM UserModelEntity p WHERE userStatus='N'")
	public List<UserModelEntity> findAll();
	
	@Override
	@Query("SELECT p FROM UserModelEntity p WHERE p.userId = :userId and userStatus='N'")
	public UserModelEntity findOne(@Param("userId") String userId);

}
