package com.project.virtusa.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class GetRunBalance {
	 public static int getRunBalance(long dat,String AccountNumber) {
			int runbal=0;
			int withdrawals=0;
			
			Connection con;
			PreparedStatement prepareStatement;
			
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysql");
			  java.sql.Timestamp ts1= new Timestamp(dat);
					  //'"+new Timestamp(dat).toString()+"' 
			prepareStatement = con.prepareStatement("select Withdrawals,RunningBalance from Transaction where Datetime in (select max(Datetime) from Transaction where DateTime < ? and  AccountNumber=?)");
			//  prepareStatement.setInt(1,Integer.parseInt(AccountNumber));

			prepareStatement.setTimestamp(1,ts1);
			 prepareStatement.setInt(2,Integer.parseInt(AccountNumber));
		        ResultSet resultSet =prepareStatement.executeQuery();
					//System.out.print(result);
		        if(resultSet.next()){
		             withdrawals = resultSet.getInt(1);
		             runbal = resultSet.getInt(2);
		             System.out.println(runbal+"utable");
				}else{
					 runbal=GetOpenBalance.getOpenBalance(AccountNumber);
					 
					 System.out.println(runbal+"mainbalance");
				}
		        }catch (Exception e) {
					e.printStackTrace();
				}
			return runbal;
			
		}
}
