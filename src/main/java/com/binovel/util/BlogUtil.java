package com.binovel.util;

public class BlogUtil {

	
	/**
	 * 截取文章的前100个字符做摘要
	 * 
	 */
	public static String getDigest(String context){
		
		if(context.length()>200){
			return context.substring(0, 201);
		}else{
			return context;
		}
		
		
	}
}
