package com.cg.oelms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oelms.dao.LoginDao;
import com.cg.oelms.entity.Login;
import com.cg.oelms.exception.LoginException;

@SpringBootTest
class OnlineECommerceLoginManagementSystemApplicationTests {

	@Autowired
	LoginDao loginDao;

	@Test
	void testLogin() throws LoginException
	{
		Login login =loginDao.validate("shara","shara123");
		assertNotNull(login);
		
	}
	@Test
	void testLoginNotExist() throws LoginException
	{
		Login login =loginDao.validate("abc","abc23");
		assertNull(login);
		
	}
	@Test
	void testFindUserExist() throws LoginException
	{
		Login login =loginDao.FindUser("shara");
		assertEquals("shara",login.getUserName());
		
	}
	@Test
	void testFindUserNotExist() throws LoginException
	{
		
		Login login =loginDao.FindUser("abc");
		assertNull(login);
		
	}
	
	
	

}
