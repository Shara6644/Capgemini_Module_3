package com.cg.pms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pms.entity.Login;
import com.cg.pms.exception.LoginException;
@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{

	@PersistenceContext
	EntityManager em;
	@Override
	public Login validate(String userName, String userPass) throws LoginException {
		String qry = "select u from Login u where u.userName=:userName and u.userPass=:userPass";
		TypedQuery<Login> query = em.createQuery(qry,Login.class);
		query.setParameter("userName", userName);
		query.setParameter("userPass", userPass);
		Login login=null;
		List<Login> list =query.getResultList();
		if(!list.isEmpty())
		login  =list.get(0);
			
		
		return login;
	}
	@Override
	public Login create(Login login) throws LoginException {
//		String qry= "Select e from Login e where e.userName=:user";
//		TypedQuery<Login>query =em.createQuery(qry,Login.class);
//		query.setParameter("user", login.getUserName());
//		List<Login> list =query.getResultList();
//		if(list.isEmpty())
//		{
//		em.persist(login);
//		}
//		else
//		{
//			throw new LoginException("username already exists");
//		}
       em.persist(login);
		return login;
	}
	@Override
	public Login FindUser(String userName) throws LoginException {
		
		Login login =em.find(Login.class, userName);
		
		
		return login;
	}

}
