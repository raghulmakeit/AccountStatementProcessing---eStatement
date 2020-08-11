package com.project.virtusa.search;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   Connection con;
	   Statement st;
	   try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysql");
			 String  AccountNumber  = request.getParameter("AccountNumber");
			 String  dateTime=request.getParameter("dateTime");
			 String  Description=request.getParameter("Description");
			 String  TxnRefNumber=request.getParameter("TxnRefNumber");
			 ArrayList al=null;
			  ArrayList account_number =new ArrayList();
			  String query = "select * from Transaction where AccountNumber='"+AccountNumber+"' or  DateTime='"+dateTime+"' or Description='"+Description+"' or TxnRefNumber='"+TxnRefNumber+"' ";
			  System.out.println("query " + query);
			  st = con.createStatement();
			  ResultSet  rs = st.executeQuery(query);
			  while(rs.next()){
				  al  = new ArrayList();
				  
				  al.add(rs.getString(1));
				  al.add(rs.getString(2));
				  al.add(rs.getString(3));
				  al.add(rs.getString(4));
				  al.add(rs.getString(5));
				  al.add(rs.getString(6));
				  al.add(rs.getString(7));
				  System.out.println("al :: "+al);
				  account_number.add(al);
				  }
			  request.setAttribute("AccountNumber",account_number);
			  
			  System.out.println("AccountNumber " +  account_number);

			   // out.println("emp_list " + emp_list);

			   String nextJSP = "/viewSearch.jsp";
			   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			   dispatcher.forward(request,response);
			   con.close();
	}catch (Exception e) {
		e.printStackTrace();
	}

}
}