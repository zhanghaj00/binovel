package com.binovel.dao;

import java.util.Date;
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
	
	public Blog getBlog(String title){
		rt.setValueSerializer(new JacksonJsonRedisSerializer<Blog>(Blog.class));
		Blog blog = (Blog)rt.opsForValue().get(title);
		return blog;
	}
	
	public void putBlog(String title,String postblog){
		rt.setValueSerializer(new JacksonJsonRedisSerializer<Blog>(Blog.class));

		Blog blog = new Blog();
		blog.setCreateTime(new Date());
		blog.setContext(postblog);
		blog.setTitle(title);
		blog.setAuthor("уе╨ф");
		System.out.println("thisi i:"+title);
		rt.opsForValue().set(title, blog);
	}
	
	
}
