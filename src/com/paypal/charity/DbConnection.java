package com.paypal.charity;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbConnection {
	private Connection conn;
	private Statement stmt;
	public DbConnection(){
		
	}
	public DbConnection(String url,String username,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,password);
	    }
	
	public Connection getConnection()
	{
		return conn;
	}

	public ResultSet executeQuery(String sqlQuery) throws SQLException
	{
		stmt=conn.createStatement();
		return stmt.executeQuery(sqlQuery);
	}
}
