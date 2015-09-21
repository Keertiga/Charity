package com.paypal.charity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckAuth {
	
	private String url;
	private String database;
	private String username;
	private String password;
	private String inputName;
	private String inputPassword;
	
	
	public CheckAuth(){}
	
	public CheckAuth(String userName,String Password){
		url="jdbc:mysql://localhost:3306";
		database="charity";
		username="root";
		password="1234";
		inputName=userName;
		inputPassword=Password;
	}
	
	 public int checkauth(){
		 int retValue = 0;
		 try {
			DbConnection db=new DbConnection(url+"/"+database,username,password);
			String sqlQuery="select * from users where username=\""+inputName+"\"";
			System.out.println(sqlQuery);
			ResultSet rs=db.executeQuery(sqlQuery);
			boolean resultExists=rs.last();
			if(resultExists==false)
				retValue=0;
			else{
				 rs.first();
				 if(inputPassword.equals(rs.getString(2))){
					 if(inputName.equals("Admin"))
						 retValue=1;
					 else
						 retValue=2;
				 }
				 else
					retValue=3;
			}
		} catch (SQLException | ClassNotFoundException e) {
		    e.printStackTrace();
		   }  
		 return retValue;
	 }
	

}
