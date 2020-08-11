package com.project.virtusa.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetOpenBalance {
	public static int getOpenBalance(String AccountNumber) throws ClassNotFoundException {
		Connection con;
		PreparedStatement prepareStatement;
		 int amt=0;
		
		System.out.print("sds");
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "mysql");
		prepareStatement = con.prepareStatement("select Balance from  MaintainBalance where AccountNumber=?");
        
        prepareStatement.setInt(1,Integer.parseInt(AccountNumber));

        ResultSet resultSet =prepareStatement.executeQuery();
			//System.out.print(result);
        if(resultSet.next()){
        	amt=resultSet.getInt(1);
        	
        }
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	
	return amt;
	}
}
