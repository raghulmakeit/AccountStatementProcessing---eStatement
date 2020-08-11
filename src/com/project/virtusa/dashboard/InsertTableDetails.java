package com.project.virtusa.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class InsertTableDetails {
	public static void insertTableDetails(String TxnRefNumber ,String AccountNumber,long dat,String Description,String Withdrawals,String Credit,int RunningBalance) throws ClassNotFoundException {
		Connection con;
		PreparedStatement prepareStatement;
		
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysql");
		prepareStatement = con.prepareStatement("insert into Transaction values(?,?,?,?,?,?,?)");
          //   java.sql.Date dat=new java.sql.Date(dateTime.getTime());
			//SimpleDateFormat myDate = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
             System.out.println(new Timestamp(dat)+" newww");
             
			prepareStatement.setString(1, TxnRefNumber);
			prepareStatement.setInt(2,Integer.parseInt(AccountNumber));
			System.out.print("pass");
			prepareStatement.setTimestamp(3,new Timestamp(dat));
			System.out.print("fpass");
			prepareStatement.setString(4, Description);
			prepareStatement.setInt(5,Integer.parseInt( Withdrawals));
			prepareStatement.setInt(6, Integer.parseInt(  Credit));
			prepareStatement.setInt(7,  RunningBalance);
			int result = prepareStatement.executeUpdate();
		//	System.out.print(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
