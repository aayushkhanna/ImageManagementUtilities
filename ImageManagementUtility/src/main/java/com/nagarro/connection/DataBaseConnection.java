package com.nagarro.connection;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file is for building the connection with database
 * */

//Imports
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
	//Creation of testConnection method
	public static Connection testConnection() {
		
		//Initialization of connection object
		Connection connection=null;
		
		//Try catch exception
		try {
			
			//Initialization of Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Managing the driver
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/assign3db","root","root");
		}
		
		//Exception handling
		catch(Exception exception) {
			System.out.println(exception);
		}
		
		//returning the connection object
		return connection;
	}
}
