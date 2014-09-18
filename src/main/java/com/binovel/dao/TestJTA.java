package com.binovel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

import org.springframework.transaction.jta.UserTransactionAdapter;

public class TestJTA {

	
	public void getSource(){
		
		
		Connection conn = null;
		UserTransaction tx = null;
		Context context;
		try {
			Class.forName("");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myuser","root","root");			
			context = new InitialContext();
			tx =  (UserTransaction)context.lookup("javax.transaction.UserTransaction");
			conn.setAutoCommit(false);
			conn.commit();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
