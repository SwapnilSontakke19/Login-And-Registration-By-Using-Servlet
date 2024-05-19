package com.AshovanIT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException    {

        String uname = request.getParameter("userId");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if user exists in the database
        try {
			if (checkUserCredentials(uname, password)) {
			    response.sendRedirect("welcome.html");
			} else {
			    out.println("<h2>User does not exist or invalid credentials. Please sign up.</h2>");
			    response.sendRedirect("registration.html");
			    //_______________________________________________________________________
			   
				
			    
			    
			    
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:33062/servletdb";
	String uid = "root";
	String psw = "root";

    private boolean checkUserCredentials(String uname, String password) throws ClassNotFoundException  {
      
        try {
        	
    		Class.forName(driver);
			Connection con = DriverManager.getConnection(url, uid, psw);
			System.out.println("connection success !!!");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33062/servletdb", "root", "root");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM userreg WHERE uname=? AND password=?");
            stmt.setString(1, uname);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if user credentials are valid, false otherwise
        } catch (SQLException e  ) {
            e.printStackTrace();
            return false; // Error occurred, return false
        }
    }
}
