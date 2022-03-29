package com.java.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="root";
		String password="root";
		
		String url="jdbc:mysql://localhost:3306/web_customer_tracker";
		String driver ="com.mysql.cj.jdbc.Driver";
		try{
			
			PrintWriter out=response.getWriter();
			out.println("Connecting to database"+url);
			Class.forName(driver);
			System.out.println("Hello");
			Connection con=DriverManager.getConnection(url, user, password);
			out.println("<br>");
			out.println("Success");
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
