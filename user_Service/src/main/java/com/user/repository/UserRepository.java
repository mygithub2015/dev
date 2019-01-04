package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
   
	@Modifying
	@Query("UPDATE UserModel p SET p.userStatus  = 'Y' WHERE p.userId = :userId") 
	void updateDeleteFlag(@Param("userId") String userId);
	
	@Override
	@Query("SELECT p FROM UserModel p WHERE userStatus='N'")
	public List<UserModel> findAll();
	
	@Override
	@Query("SELECT p FROM UserModel p WHERE p.userId = :userId and userStatus='N'")
	public UserModel findOne(@Param("userId") String userId);

}
