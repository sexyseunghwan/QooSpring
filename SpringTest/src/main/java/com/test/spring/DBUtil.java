package com.test.spring;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private Connection conn = null;
	
	public Connection open() {
		
		//String url = "jdbc:sqlserver://192.168.0.2:11289;database=ADMIN";
		//String id = "seunghwan";
		//String pw = "byeanma170125";
		
		String url = "jdbc:sqlserver://218.48.201.158:11289;database=ADMIN";
		String id = "seunghwan";
		String pw = "byeanma170125";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("성공"); //db 연결되었는지 확인해준다.
			
			return conn;
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("문제가 존나게 생김");
		}
		
		return null;
	}

}