package com.binovel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRedis {

	@Autowired
	RedisTemplate redisTemplate;
	
	public void  getBlog(){
		
		
		RedisTemplate rt = redisTemplate;  
		          
		rt.opsForValue().set("zhang", "hao");  
		          
		System.out.println(rt.opsForValue().get("zhang"));  

	}
}
