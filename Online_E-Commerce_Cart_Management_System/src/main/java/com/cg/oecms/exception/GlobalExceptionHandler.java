package com.cg.oecms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




	@ControllerAdvice
	public class GlobalExceptionHandler {
		
		@ExceptionHandler(CartException.class)
		public @ResponseBody ResponseEntity<ErrorInfo>  handleException(CartException ex,HttpServletRequest req)
		{
			
			 String message=ex.getMessage();
			 String uri= req.getRequestURI();
			 
			 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
			 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
			 return re;
		}


		@ExceptionHandler(ProductException.class)
		public @ResponseBody ResponseEntity<ErrorInfo>  handleException(ProductException ex,HttpServletRequest req)
		{
			
			 String message=ex.getMessage();
			 String uri= req.getRequestURI();
			 
			 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
			 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
			 return re;
		}
		@ExceptionHandler(LoginException.class)
		public @ResponseBody ResponseEntity<ErrorInfo>  handleException(LoginException ex,HttpServletRequest req)
		{
			
			 String message=ex.getMessage();
			 String uri= req.getRequestURI();
			 
			 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
			 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
			 return re;
		}
		@ExceptionHandler(Exception.class)
		public @ResponseBody ResponseEntity<ErrorInfo>  handleException(Exception ex,HttpServletRequest req)
		{
			
			 String message=ex.getMessage();
			 String uri= req.getRequestURI();
			 
			 ErrorInfo  obj = new ErrorInfo(LocalDateTime.now(),message,uri);
			 ResponseEntity<ErrorInfo>  re = new ResponseEntity<ErrorInfo>(obj,HttpStatus.NOT_FOUND);
			 return re;
		}
		
}
