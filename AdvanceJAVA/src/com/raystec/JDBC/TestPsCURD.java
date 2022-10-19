package com.raystec.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPsCURD {
	public static void main(String[] args) throws Exception {

//		TestAdd();
//		TestUpdate();
//		TestDelete();
//		TestGetById();
		TestSelect();

	}

	private static void TestSelect() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		PreparedStatement ps = conn.prepareStatement("Select * from employee");

		ResultSet rs = ps.executeQuery();

		System.out.println("ID\tFirst Name\tLast Name\tSalary\t\tDepartment ID");

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t\t" + rs.getString(3));
			System.out.print("\t\t" + rs.getString(4));
			System.out.println("\t\t" + rs.getString(5));
		}
		conn.close();
		ps.close();
		rs.close();

	}

	private static void TestGetById() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		int id = 4;

		PreparedStatement ps = conn.prepareStatement("Select * from employee where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		System.out.println("ID\tFirst Name\tLast Name\tSalary\t\tDepartment ID");

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t\t" + rs.getString(3));
			System.out.print("\t\t" + rs.getString(4));
			System.out.println("\t\t" + rs.getString(5));
		}
		conn.close();
		ps.close();
		rs.close();

	}

	private static void TestDelete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		int id = 7;

		PreparedStatement ps = conn.prepareStatement("Delete from employee where id = ?");

		ps.setInt(1, id);

		ps.execute();

		conn.close();
		ps.close();

		System.out.println(id + " is Deleted");

	}

	private static void TestUpdate() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		int id = 2;
		String ln = "Jain";

		PreparedStatement ps = conn.prepareStatement("update employee set lname = ? where id = ?");

		ps.setString(1, ln);
		ps.setInt(2, id);

		ps.execute();

		conn.close();
		ps.close();

		System.out.println("Updated");
	}

	private static void TestAdd() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		int id = 7;
		String fn = "Aryant";
		String ln = "Sharma";
		int sal = 45000;
		int did = 6;

		PreparedStatement ps = conn.prepareStatement("Insert into Employee values(?,?,?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setInt(4, sal);
		ps.setInt(5, did);

		ps.execute();

		conn.close();
		ps.close();

		System.out.println("Inserted");
	}
}
