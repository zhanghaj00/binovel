package com.binovel.controller;


import java.io.UnsupportedEncodingException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.ui.ModelMap;
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
	JtaTransactionManager springTransactionManager;
	
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
	public String getblog(ModelMap map ,@RequestParam(required=false)String key) throws UnsupportedEncodingException{
		
		//HashMap<String, Object> response = new HashMap<String, Object>();
		map.put("bloglist", blogDao.getBlog("���"));
		//System.out.println("this is key"+new String(key.getBytes("ISO8859-1"),"utf-8"));
		//blogDao.insertBlog();
		System.out.println(key);
		return "blog.jsp";
		
	}
	
	@RequestMapping("/publish")
	public String publish(){
		System.out.println("transactionManager:"+springTransactionManager);
		return "publicblog.jsp";
	}
	@RequestMapping(value="/publishsuccess")
	public String publishsuc(String title,String postblog) throws UnsupportedEncodingException{
		title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
		blogDao.putBlog(title, postblog);
		return "redirect:/user/getblog.html";
	}
}
