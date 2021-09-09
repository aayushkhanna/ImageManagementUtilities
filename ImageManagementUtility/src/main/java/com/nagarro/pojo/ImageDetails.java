package com.nagarro.pojo;
/*
 * @Aayush Khanna
 * Technology Trainee
 * 
 * This class is used to make getters and setters for Image Details and making connection with database
 * */

//Imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity  //specifies table creation
public class ImageDetails {
	@Id  //Identifies as primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//Declaration of variables
	private int SerialNumber;
	private String UserName;
	private String Name;
	private String Size;
	private String Image;

	//Get method for UserName 
	public String getUserName() {
		return UserName;
	}

	//Set method for UserName
	public void setUserName(String userName) {
		UserName = userName;
	}

	//get method for Serial Number
	public int getSerialNumber() {
		return SerialNumber;
	}

	//set method for Serial Number
	public void setSerialNumber(int SerialNumber) {
		SerialNumber = SerialNumber;
	}

	//get method for Name
	public String getName() {
		return Name;
	}

	//set method for Name
	public void setName(String name) {
		Name = name;
	}

	//get method for Image size
	public String getSize() {
		return Size;
	}

	//set method for image size
	public void setSize(String size) {
		Size = size;
	}

	//get method for Image
	public String getImage() {
		return Image;
	}

	//set method for Image
	public void setImage(String image) {
		Image = image;
	}
}

