package com.binovel.util;

public class BlogUtil {

	
	/**
	 * ��ȡ���µ�ǰ100���ַ���ժҪ
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
