package com.raystec.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {

		ResourceBundle rb = ResourceBundle.getBundle("com.raystec.rb.app");
	
	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName(rb.getString("driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	 public void Add(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		PreparedStatement ps = conn.prepareStatement("Insert into Marksheet values(?,?,?,?,?,?,?)");
		
		conn.setAutoCommit(false);
		
		ps.setInt(1, nextPk());
		ps.setInt(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhy());
		ps.setInt(6, bean.getChem());
		ps.setInt(7, bean.getMath());

		ps.executeUpdate();
		conn.commit();
		
		conn.close();
		ps.close();

		System.out.println("Inserted");
}

	public static void Delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		PreparedStatement ps = conn.prepareStatement("Delete from Marksheet where id = ?");
		
		conn.setAutoCommit(false);
		
		ps.setInt(1, bean.getId());

		ps.executeUpdate();

		conn.commit();
		conn.close();
		ps.close();

		System.out.println(bean.getId() + " is Deleted");

	}

	public static void Update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		PreparedStatement ps = conn.prepareStatement("update marksheet set lname = ? where id = ?");

		conn.setAutoCommit(false);
		
		ps.setString(1, bean.getLname());
		ps.setInt(2, bean.getId());

		ps.executeUpdate();
		
		conn.commit();
		conn.close();
		ps.close();
		System.out.println(bean.getId() + " is Updated");
	}

	public static MarksheetBean GetById(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

	    conn.setAutoCommit(false);;

		PreparedStatement ps = conn.prepareStatement("Select * from marksheet where RollNo = ?");

		ps.setInt(1, bean.getRollno());

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean1 = null;
		
		System.out.println("ID\tRoll No\tFName\tLName\tPhy\tChem\tMath");

		while (rs.next()) {
			bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollno(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMath(rs.getInt(7));
		}
		
		
		conn.commit();
		conn.close();
		ps.close();
		rs.close();
		return bean1;

	}

	public static List<MarksheetBean> Select(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("Select * from marksheet");

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean1 = null;

		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		System.out.println("ID\tRoll No\tFName\tLName\tPhy\tChem\tMath");

		while (rs.next()) {
			bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollno(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMath(rs.getInt(7));
			list.add(bean1);
		}

		conn.commit();
		conn.close();
		ps.close();
		rs.close();
		return list;

	}

	public List<MarksheetBean> Merit(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "P&r042509");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(
				"Select *,(phy+chem+math) as Total, ((phy+chem+math)/3) as Percentages from marksheet where phy>40 and chem>40 and math>40 order by Total Desc limit 0,5");

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean1 = null;

		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();

		System.out.println("ID\tRoll No\tFName\t\tLName\t\tPhy\tChem\tMath\tTotal\tPercentages");

		while (rs.next()) {
			bean1 = new MarksheetBean();
			bean1.setId(rs.getInt(1));
			bean1.setRollno(rs.getInt(2));
			bean1.setFname(rs.getString(3));
			bean1.setLname(rs.getString(4));
			bean1.setPhy(rs.getInt(5));
			bean1.setChem(rs.getInt(6));
			bean1.setMath(rs.getInt(7));
			bean1.setTotal(rs.getInt(8));
			bean1.setPercentage(rs.getDouble(9));
			list.add(bean1);
		}

		conn.commit();
		conn.close();
		ps.close();
		rs.close();
		return list;

	}
}
