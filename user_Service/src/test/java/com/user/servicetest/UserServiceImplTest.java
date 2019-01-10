package com.user.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.user.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@MockBean
	UserServiceImpl userServiceImplTest;
	
	@Test
	public void findByIdTest(){
		
}

		
}
	

