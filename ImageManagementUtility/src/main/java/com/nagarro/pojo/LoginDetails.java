package com.nagarro.pojo;
/*
 * @Aayush Khanna
 * Technology Trainee
 * 
 * This class is used to make getters and setters for Login Details and making connection with database
 * */

//Imports
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //specifies table creation
public class LoginDetails {
	@Id   //Identifies as primary key
	
	//Declaration of variables
	private String username;
	private String password;

	//getter method for UserName
	public String getUsername() {
		return username;
	}
	
	//setter method for username
	public void setUsername(String username) {
		this.username = username;
	}
	
	//getter method for password
	public String getPassword() {
		return password;
	}

	//setter method for password
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

