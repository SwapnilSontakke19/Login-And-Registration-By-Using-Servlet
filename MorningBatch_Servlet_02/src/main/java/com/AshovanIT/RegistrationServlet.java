package com.AshovanIT;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		Long umobile = Long.parseLong(mobile);
		String ucollege = request.getParameter("college");
		
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h2> Name: " + uname + "</h2><br>");
		out.print("<h2> Email: " + uemail + "</h2><br>");
		out.print("<h2> Mobile: " + umobile + "</h2><br>");
		out.print("<h2> College: " + ucollege + "</h2><br>");
	
		out.print("<h2> Password: " + password + "</h2><br>");
		// database connect:
		DataBaseConnection.getConnection(uname, uemail, umobile, ucollege, password);

	}

}
