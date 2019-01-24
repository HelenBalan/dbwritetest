package com.elenabalan.dbtest.entity_random_file;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://192.168.99.100:32773/testedDb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
		String user = "testuser";
		String pass = "testuser";
		
		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connecting successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
