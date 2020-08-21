package com.cg.oelms.dao;

import com.cg.oelms.entity.Login;
import com.cg.oelms.exception.LoginException;

public interface LoginDao {
	
	public Login validate(String userName,String password) throws LoginException;
   public Login create(Login login) throws LoginException;
   public Login FindUser(String userName) throws LoginException;
}
