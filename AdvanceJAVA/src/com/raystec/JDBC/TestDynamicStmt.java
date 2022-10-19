package com.raystec.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDynamicStmt {
	public static void main(String[] args) throws Exception {
		
		TestAdd();
	}

	private static void TestAdd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();
		
		int id = 6;
		String fn = "Vedant";
		String ln = "Rao";
		int sal = 35000;
		int did = 2; 

		int i = stmt.executeUpdate("insert into employee values("+id+",'"+fn+"','"+ln+"',"+sal+","+did+")");
		
		System.out.println(i + " Inserted");
		
	}
}
