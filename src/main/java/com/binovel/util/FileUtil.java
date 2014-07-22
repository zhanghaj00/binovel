package com.binovel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.binovel.common.MyFileAttr;
import com.binovel.domain.Blog;

public class FileUtil {

	
	public void getFile(String filepath){
		try {
			List<String> list= Files.readAllLines(Paths.get(filepath), Charset.forName("gbk"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile(){
		
		
	}
	
	public void appendFile(){
		
		
	}
	
	
	public void createFile(Blog blog){
		
		
		//判断用户是不是已经有了自己的文件夹
		///Files.isDirectory(blog.getAuthor());
		//创建作者文件夹
		String path = blog.getId()+":"+blog.getTitle()+":"+blog.getCreateTime();
		String point = blog.getId()+":"+blog.getTitle()+":"+blog.getCreateTime()+"point";
		//创建文件
		ArrayList<String> filecontext = new ArrayList();
		//
		try {
			/*Set<PosixFilePermission> perms 
		    = PosixFilePermissions.fromString("rw-rw-rw-");

			Files.createFile(Paths.get(""),PosixFilePermissions.asFileAttribute(perms));
			*/
			Files.createFile(Paths.get(path));
			filecontext.add("/n"+blog.getAuthor()+":"+blog.getTitle());
			filecontext.add("/n"+blog.getContext());
			
			Files.write(Paths.get(path), filecontext, Charset.forName("gbk"),StandardOpenOption.APPEND );
			
		//	Files.write(Paths.get(point), filecontext, Charset.forName("gbk"),StandardOpenOption.APPEND)
		} catch (IOException e) {
			System.out.println("写入数据错误");
			e.printStackTrace();
		}finally{
			
			
		}
		
	}
	
	
	public void myFile() throws IOException{
		RandomAccessFile file = new RandomAccessFile(new File("e:/linux常用命令.txt"), "r");
		file.seek(30);
		byte[] b = new byte[1024];
		int isRead = 0;
		//file.setLength(80);
		while((isRead = file.read(b))>0){
			System.out.println(new String(b,0,isRead));
		}
		
		System.out.println(file.getFilePointer());
		
	}
	
}
