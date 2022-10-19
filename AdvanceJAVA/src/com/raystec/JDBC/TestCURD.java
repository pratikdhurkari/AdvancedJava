package com.raystec.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCURD {

	public static void main(String[] args) throws Exception {

//		testSelect();
//		testAdd();
//		testUpdate();
//		testDelete();
		testGetByID(0);
	}



	private static void testGetByID(int i) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from employee where id = 5");

		System.out.println("ID\tFirst Name\tLast Name\tSalary\t\tDepartment ID");

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t\t" + rs.getString(3));
			System.out.print("\t\t" + rs.getString(4));
			System.out.println("\t\t" + rs.getString(5));

		}
		conn.close();
		stmt.close();
		rs.close();
		
		
	}

	private static void testDelete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from employee where id = 9");
		
		System.out.println(i + " Deleted");
		conn.close();
		stmt.close();
		
	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update employee set lname = 'Jain' where id = 1");
		
		System.out.println(i + " Updated");
		
		conn.close();
		stmt.close();
		
	}

	private static void testAdd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee values(9,'Rajesh','Khanna',12500,4)");
		
		System.out.println(i + " Inserted");
		conn.close();
		stmt.close();
	}

	private static void testSelect() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from employee");

		System.out.println("ID\tFirst Name\tLast Name\tSalary\t\tDepartment ID");

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t\t" + rs.getString(3));
			System.out.print("\t\t" + rs.getString(4));
			System.out.println("\t\t" + rs.getString(5));

		}
		conn.close();
		stmt.close();
		rs.close();
	}
}
