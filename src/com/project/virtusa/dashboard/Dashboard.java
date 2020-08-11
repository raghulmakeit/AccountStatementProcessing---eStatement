package com.project.virtusa.dashboard;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.virtusa.login.ApplicationLoginValidate;
//Extend HttpServlet class
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
private String message;




public void init() throws ServletException {


}

public void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {

	 if(ServletFileUpload.isMultipartContent(request)){
     try {
         List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
         for(FileItem item : multiparts){
             if(!item.isFormField()){
                 String name = new File(item.getName()).getName();
                 System.out.println("name--="+name);       
             InputStream inputStream= item.getInputStream();	   	 
    	       BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
    		    StringBuilder respons = new StringBuilder();
    		    String currentLine;	
    		    while ((currentLine = in.readLine()) != null) {
    		    	System.out.println(currentLine);
    		    	StringTokenizer st = new StringTokenizer(currentLine,",");
    		    	int acrunbal=0;
    		    	String TxnRefNumber="",AccountNumber="",date1="",Withdrawals="",Credit="",Description="",RunningBalance="";
    		    	TxnRefNumber=st.nextToken();
    		    	AccountNumber=st.nextToken();
    		    	date1=st.nextToken();
                     //Convert DateTime to Long
    		    	SimpleDateFormat myDate = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
    		    	java.util.Date dateTime = myDate.parse(date1);
    		    	long time=dateTime.getTime();
    		    	int runbal=	GetRunBalance.getRunBalance(time, AccountNumber);
    		    	System.out.println(runbal);
    		    	Description=st.nextToken();
    		    	Withdrawals=st.nextToken();
    		    	Credit=st.nextToken();
    		    	if(Integer.parseInt(Withdrawals)!=0){
    		    		acrunbal=runbal-Integer.parseInt(Withdrawals);
    		    	}
    		    	else if(Integer.parseInt(Credit)!=0){
    		    		acrunbal=runbal+Integer.parseInt(Credit);
    		    	}
    	
    		    	//RunningBalance=st.nextToken();
    		    
    		    	InsertTableDetails.insertTableDetails(TxnRefNumber,AccountNumber,time,Description,Withdrawals,Credit,acrunbal);
    		    	UpdateRunningBalance.updateRunningBalance(time, AccountNumber,acrunbal);
    		    
    		    	//while (st.hasMoreTokens()) {
    		       //	System.out.println(st.nextToken());
 
    		    }
    		     }
         }
        
        
     } catch (Exception ex) {
        request.setAttribute("errormsg", "File Upload Failed due to " + ex);
     }         		
 }else{

     request.setAttribute("errormsg","No File found");
}
	// request.getRequestDispatcher("/Display.jsp").forward(request, response);
	// response.sendRedirect("Display.jsp.jsp");
	 //response.sendRedirect("http://localhost:8080/AccountStatement/Display");
	 response.sendRedirect("Dashboard");
} 


public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	// Set response content type
	   response.setContentType("text/html");

	   // Actual logic goes here.
	   PrintWriter out = response.getWriter();
	   out.println("<h1>" + message + "</h1>");
	   out.flush();
}

public void destroy() {
// do nothing.
}
}