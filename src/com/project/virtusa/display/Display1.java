package com.project.virtusa.display;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display1")
public class Display1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection connection;
    
	   
			
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	 }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.print(dopost());
		try {
			 Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","mysql");
			Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select * from Transaction");
			PrintWriter out = response.getWriter();
			  response.setContentType("text/html");   
			//ArrayList al=new ArrayList();
		   ArrayList table_list =new ArrayList();
			
			while(resultSet.next())
			{
				ArrayList al=new ArrayList();
				System.out.println(resultSet.getString(1)+"1st");
				al.add(resultSet.getString(1));
				al.add(resultSet.getString(2));
				al.add(resultSet.getString(3));
				al.add(resultSet.getString(4));
				al.add(resultSet.getString(5));
				al.add(resultSet.getString(6));
				al.add(resultSet.getString(7));
				System.out.print(al);
				table_list.add(al);
			}
			request.setAttribute("table", table_list);
			for (int i = 0; i < table_list.size(); i++) 
	            System.out.print(table_list.get(i) + " "); 
		//	request.setAttribute("table_list",table_list);
			 
				  //  RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
			        //rd.include(request, response);  
				
				/*ServletContext servletContext = getServletContext();
				String contextPath = servletContext.getRealPath(File.separator);
				PrintWriter out = response.getWriter();
				out.println("<br/>File system context path (in TestServlet): " + contextPath);
				jasperReport = JasperCompileManager.compileReport("Blank_A4_Landscape.jrxml");
			
	   
	         // Parameters for report
	         Map<String, Object> parameters = new HashMap<String, Object>();
	   
	         // DataSource
	         // This is simple example, no database.
	         // then using empty datasource.
	         JRDataSource dataSource = new JREmptyDataSource();
	   
	         JasperPrint jasperPrint;
			
				jasperPrint = JasperFillManager.fillReport(jasperReport,  parameters, dataSource);
			
	   
	      
	         // Make sure the output directory exists.
	         File outDir = new File("D:/jasperoutput");
	         outDir.mkdirs();
	   
	         // Export to PDF.
	         JasperExportManager.exportReportToPdfFile(jasperPrint,"D:/jasperoutput/StyledTextReport.pdf");*/
				String str=    request.getParameter("mimeType");
				    if(str.equalsIgnoreCase("EXCEL")){
				    request.setAttribute("Mime","EXCEL");
				    }
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Display.jsp");
			   dispatcher.forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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









