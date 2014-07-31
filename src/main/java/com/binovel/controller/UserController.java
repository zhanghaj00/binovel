package com.binovel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/commonlogin") 
	public String UserLoginC(){
		
		System.out.println("commonlogin ------");
		return "login/login.jsp";
		
	}
	@RequestMapping("/searchlist") 
	public String UserLoginS(){
		
		System.out.println("speclogin ------");
		return "searchlist.jsp";
		
	}
}
