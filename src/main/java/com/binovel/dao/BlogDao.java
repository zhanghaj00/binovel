package com.binovel.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.binovel.domain.Blog;


@Repository
public class BlogDao {

	@Autowired
	private RedisTemplate rt;
	
	
	public void insertBlog(){
		
		rt.setValueSerializer(new JacksonJsonRedisSerializer<Blog>(Blog.class));
		Blog blog = new Blog();
		blog.setAuthor("zhanhgoa");
		blog.setContext("shide");
		blog.setId(4);
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		blog.setTitle(id);
		
		rt.opsForValue().set(id, blog);
		
		this.getBlog(id);
	}
	
	public void getBlog(String uuid){
		rt.setValueSerializer(new JacksonJsonRedisSerializer<Blog>(Blog.class));
		
		Blog blog = (Blog)rt.opsForValue().get(uuid);
		
		System.out.println(blog.getId());
		System.out.println(blog.getAuthor());
		System.out.println(blog.getContext());
	}
}
