package com.binovel.listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg1.setContentType("text/html; charset=UTF-8");
		System.out.println("encoding filter"+arg0.getCharacterEncoding());
		//arg0.setCharacterEncoding("ISO-8859-1");
		arg2.doFilter(arg0, arg1);
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
