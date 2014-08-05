package com.binovel.controller;


import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		//�ύ�ɹ������ת��һ���ɹ����� ������ redirect ��ֹ�ظ��ύ
		System.out.println("commonlogin ------");
		return "login/login.jsp";
		
	}
	@RequestMapping("/searchlist") 
	public String UserLoginS(@RequestParam(required=false)String key) throws UnsupportedEncodingException{
		System.out.println("this is key"+new String(key.getBytes("ISO8859-1"),"utf-8"));
		//blogDao.insertBlog();
		System.out.println(key);
		return "searchlist.jsp";
		
	}
	@RequestMapping("/getblog") 
	public String getblog(@RequestParam(required=false)String key) throws UnsupportedEncodingException{
		//System.out.println("this is key"+new String(key.getBytes("ISO8859-1"),"utf-8"));
		//blogDao.insertBlog();
		System.out.println(key);
		return "blog.jsp";
		
	}
}
