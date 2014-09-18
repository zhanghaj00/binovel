package com.binovel.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SpringBeanTest implements BeanFactoryAware,
      BeanNameAware,InitializingBean,DisposableBean{

	
	private String id;
	private String name;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("真实的调用注入属性值得方法");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SpringBeanTest(){
		System.out.println("构造器初始化这个TestBean");
	}

	
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("这个是afterpropertiseSet方法");
	}

	
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
      System.out.println("这个是setBeanName方法");
	}

	
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("这个是BeanFactory的方法");
		
	}

	
}
