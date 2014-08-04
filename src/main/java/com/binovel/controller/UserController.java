package com.binovel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binovel.dao.BlogDao;
import com.binovel.dao.TestRedis;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	TestRedis redis;
	
	@Autowired
	BlogDao blogDao;
	@RequestMapping("/commonlogin") 
	public String UserLoginC(){
		
		System.out.println("commonlogin ------");
		return "login/login.jsp";
		
	}
	@RequestMapping("/searchlist") 
	public String UserLoginS(){
		blogDao.insertBlog();
		return "searchlist.jsp";
		
	}
}
