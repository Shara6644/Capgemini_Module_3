package com.cg.pms.service;

import com.cg.pms.entity.Login;
import com.cg.pms.exception.LoginException;

public interface LoginService {
	
	public String validate(String userName,String userPass) throws LoginException;
	 public Login create(Login login) throws LoginException;

}
