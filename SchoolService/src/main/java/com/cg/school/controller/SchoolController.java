package com.cg.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

	@GetMapping("school/getname")
	public ResponseEntity<String>getSchoolName()
	{
		String str ="Bvrit School";
		ResponseEntity<String> re = new ResponseEntity<>(str,HttpStatus.OK);
		return re ;
	}
	
	
	
}
