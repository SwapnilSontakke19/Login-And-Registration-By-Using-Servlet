package com.AshovanIT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {
	public static void getConnection(String uname, String uemail, Long umobile, String ucollege,
			String password) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:33062/servletdb";
		String uid = "root";
		String psw = "root";
		String sql = "insert into userreg values (?,?,?,?,?)";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, psw);
			System.out.println("connection success !!!");

			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setLong(3, umobile);
			ps.setString(4, ucollege);
			
			ps.setString(5, password);

			int uq = ps.executeUpdate();

			if (uq < 0) {
				System.out.println("<h2> DATA INSERTION FAIL </h2><br>");
			} else {
				System.out.println("<h2> SUCCESS </h2><br>");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}