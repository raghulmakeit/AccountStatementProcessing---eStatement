package com.project.virtusa.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class UpdateRunningBalance {
	 public static void updateRunningBalance(long dat,String AccountNumber,int runbal) {
	   		int acrunbal=runbal;
	   		int withdrawals=0;
	   		Connection con;
	   		PreparedStatement prepareStatement;
	   		
	   		try{
	   		Class.forName("com.mysql.cj.jdbc.Driver");
	   		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysql");
	   		System.out.println("kiki ");
	   		prepareStatement = con.prepareStatement("select TxnRefNumber,Datetime, Withdrawals,Credit,RunningBalance from Transaction where Datetime in (select min(Datetime) from Transaction where DateTime >? and AccountNumber=?)");
	   		//  prepareStatement.setInt(1,Integer.parseInt(AccountNumber));
	   

	   		prepareStatement.setTimestamp(1,new Timestamp(dat));
	   		 prepareStatement.setInt(2,Integer.parseInt(AccountNumber));
	   	        ResultSet resultSet =prepareStatement.executeQuery();
	   				//System.out.print(result);
	   	        while(resultSet.next()){
	   	        String	TxnRefNumber = resultSet.getString(1);//4,5
	   	          withdrawals = resultSet.getInt(3);//230,1500
	   	          int Credit = resultSet.getInt(4);//0,0
	   	       if((withdrawals)!=0){
		    		acrunbal=acrunbal-withdrawals;//18025,17795
		    		System.out.print(acrunbal+"if");
		    	}
		    	else if(Credit!=0){
		    		acrunbal=acrunbal+Credit;
		    		System.out.print(acrunbal+"elseif");
		    	}
	   		prepareStatement = con.prepareStatement("update transaction set RunningBalance=? where AccountNumber=? and TxnRefNumber=?");
			prepareStatement.setInt(1, acrunbal);
			prepareStatement.setInt(2,Integer.parseInt(AccountNumber));
			prepareStatement.setString(3,TxnRefNumber);
		    prepareStatement.executeUpdate();
	   	        
	   			}
	   	        }catch (Exception e) {
	   				e.printStackTrace();
	   			}
	  
	   		
	   	}
	}

