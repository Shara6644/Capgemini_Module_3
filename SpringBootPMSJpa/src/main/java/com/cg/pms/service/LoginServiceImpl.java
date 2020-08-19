package com.cg.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pms.dao.LoginDao;
import com.cg.pms.entity.Login;
import com.cg.pms.exception.LoginException;
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	 
	@Override
	public String validate(String userName, String userPass) throws LoginException {
		Login login =loginDao.validate(userName, userPass);
		if(login==null)
		{
			throw new LoginException("Login Failed");
		}
		return login.getUser_role();
	}

	@Override
	public Login create(Login login) throws LoginException {
		Login login1 =loginDao.FindUser(login.getUserName());
		 if(login1!=null)
		 {
			 throw new LoginException("User Already Exists");
		 }
		 
		return loginDao.create(login);
	}

}
