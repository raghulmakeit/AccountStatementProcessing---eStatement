package com.project.virtusa.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
//@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection connection;
    
	   
	 public void init(ServletConfig config){
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","mysql");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.print(dopost());
		try {
			Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from Transaction");
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.print("TxnRefNumber");
			out.print("</th>");
			out.print("<th>");
			out.print("AccountNumber");
			out.print("</th>");
			out.print("<th>");
			out.print("DateTime");
			out.print("</th>");
			out.print("<th>");
			out.print("Description");
			out.print("</th>");
			out.print("<th>");
			out.print("Withdrawals");
			out.print("</th>");
			out.print("<th>");
			out.print("Credit");
			out.print("</th>");
			out.print("<th>");
			out.print("RunningBalance");
			out.print("</th>");
			out.print("</tr>");
			
			while(resultSet.next())
			{
				out.println("<tr>");
				out.println("<td>");
				out.print(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(4));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(5));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(6));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(7));
				out.println("</td>");
				out.println("</tr>");
			}
			out.print("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void destroy(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	 }

}









