package com.cg.pms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pms.entity.Login;
import com.cg.pms.exception.LoginException;
import com.cg.pms.service.LoginService;

@RestController
@CrossOrigin("*")
public class LoginController {
	@Autowired
	LoginService service;
	
	@GetMapping("login/validate/{user}/{pass}")
	public ResponseEntity<String> validate(@PathVariable("user") String user,@PathVariable("pass") String pass) throws LoginException
	{
		
		String role =service.validate(user,pass);
		ResponseEntity<String> re=new ResponseEntity<>(role,HttpStatus.OK);
		return re;
	}
	@PostMapping("login")
	public ResponseEntity<Login> validate(@RequestBody Login login) throws LoginException
	{
		
		 login= service.create(login);
		ResponseEntity<Login> re=new ResponseEntity<>(login,HttpStatus.OK);
		return re;
	} 

}
