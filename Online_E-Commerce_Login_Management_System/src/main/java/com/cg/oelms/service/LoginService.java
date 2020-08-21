package com.cg.oelms.service;

import com.cg.oelms.entity.Login;
import com.cg.oelms.exception.LoginException;


public interface LoginService {
	
	public Login validate(String userName,String password) throws LoginException;
	 public Login create(Login login) throws LoginException;

}
