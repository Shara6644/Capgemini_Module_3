package com.cg.oecms.controller;
class Person
{
  public  String name;
	public void displayName()
	{
		System.out.println("abc");
	}
	
	
	
	
}
class Manager extends Person
{
	public void displayName()
	{
	  System.out.println("xyz");	
	}
	
}

public class TestController {
	
   public static void main(String[] args) {
	   
	   Manager manager =new Manager();
	   manager.displayName();
	   
	   
		
	}
	public int add(int a,int b)
	{
		int sum=a+b;
		return sum;
	}
	public int add(int a ,int b,int c)
	{
		int sum=a+b+c;
		return sum;
	}
 public String add(String a,String b)
 {
	String str= a.concat(b);
	 return str;
 }
}
