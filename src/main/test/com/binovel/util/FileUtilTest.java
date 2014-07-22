package com.binovel.util;

import java.io.IOException;

import org.junit.Test;

public class FileUtilTest {

	@Test
	public void getFileTest(){
		try {
			new FileUtil().myFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
