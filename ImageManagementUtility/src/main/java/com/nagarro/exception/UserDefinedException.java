package com.nagarro.exception;
/*
 * @Aayush Khanna
 * Technology Trainee
 * 
 * This class is used for exception handling
 * */
public class UserDefinedException extends Exception{

	//Initializing private variables
	private static final long serialVersionUID = 1L;

	//UserDefinedException method initialization
	public UserDefinedException(String userDefinedExceptionString) {
		super(userDefinedExceptionString);
	}

	
}
