package com.raystec.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	ResourceBundle rb = ResourceBundle.getBundle("com.raystec.rb.app");
	
	private static JdbcDataSource jds;
	private ComboPooledDataSource ds;

	private JdbcDataSource() throws Exception {

		ds = new ComboPooledDataSource();
		ds.setDriverClass(rb.getString("driver"));
		ds.setJdbcUrl(rb.getString("url"));
		ds.setUser(rb.getString("user"));
		ds.setPassword(rb.getString("pwd"));
		ds.setInitialPoolSize(5);
		ds.setAcquireIncrement(5);
		ds.setMaxPoolSize(5);
	}

	public static JdbcDataSource getInstance() throws Exception {

		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	public static Connection getConnection() throws Exception {

		return getInstance().ds.getConnection();
	}

	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {

		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();

	}

	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt);
	}

	public static void closeConnection(Connection conn) {

		closeConnection(conn);
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 6; i++) {

			String sql = "Select * from Marksheet;";

			Connection conn = JdbcDataSource.getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("DB Pool Connection " + (i + 1));
			System.out.println("ID\tRoll\tFname\tLname\t\tPhy\tChem\tMath");

			while (rs.next()) {

				System.out.print(rs.getInt(1));
				System.out.print("\t" + rs.getInt(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + rs.getString(4));
				System.out.print("     \t" + rs.getInt(5));
				System.out.print("\t" + rs.getInt(6));
				System.out.println("\t" + rs.getInt(7));

			}
//		JdbcDataSource.closeConnection(conn, stmt, rs);
		}
	}
}
