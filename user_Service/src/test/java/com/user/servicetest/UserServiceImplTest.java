package com.user.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.user.model.UserModelBean;
import com.user.model.UserModelEntity;
import com.user.repository.UserRepository;
import com.user.service.UserServiceImpl;
import com.user.testUtility.TestHelper;

import io.user.UserServiceApplicationTests;



public class UserServiceImplTest extends UserServiceApplicationTests{

   @Mock
   UserRepository userRepository;
   
   @InjectMocks
   private UserServiceImpl userServiceImpl;
   
   @Before
   public void setUp() throws Exception {
                   MockitoAnnotations.initMocks(this);
   }

	@Test
	public void testFindById(){
		String userId="1";
		UserModelEntity udEntinty=TestHelper.getEntityObj();
        Mockito.when(userRepository.findOne(userId)).thenReturn(udEntinty);
            UserModelBean details = userServiceImpl.findById(userId);
        assertEquals("1", details.getUserId());
	}
	
	@Test
	public void testCreateUser(){
		UserModelBean userBean=TestHelper.getBeanObj();
		UserModelEntity udEntinty=TestHelper.getEntityObj();
		Mockito.when(userRepository.save(Mockito.any(UserModelEntity.class))).thenReturn(udEntinty);
		UserModelBean details1=userServiceImpl.createUser(userBean);
		assertEquals("1", details1.getUserId());
	}
	
	@Test
	public void testGetAllUsers(){
		List<UserModelEntity> userModelEntity=TestHelper.getEntitylist();
		Mockito.when(userRepository.findAll()).thenReturn(userModelEntity);
		List<UserModelBean> details1=userServiceImpl.getAllUsers();
		assertEquals("1", details1.get(0).getUserId());
		
	}
		}	




