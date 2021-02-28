package com.vti.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	private short id;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private Group[] groups;

//==========================================================================================
//	this added prior to Lesson 4 - exercise 1 - question 2

//Question 2:
//Tạo constructor cho Account:
	
//a) Không có parameters
	public Account() {
	}
	
//b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
	public Account(short id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
	}
	
//c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
	public Account(short id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = new Date();
	}
	
//d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
		public Account(short id, String email, String userName, String firstName, String lastName, Position position, Date createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

//	Create a constructor with user name only - for assignment 4 - ex1 - question3c
	public Account(String userName) {
		this.userName = userName;
	}		
//==========================================================================================
	@Override
	public String toString() {
		Position position = new Position();
		
		return id + " " + email + " " + userName + " " + fullName + " " + (position != null ? position.getName(): "|Position is null|") + " " + createDate;
	}
//==========================================================================================
	public String getUserName() {
		return userName;
	}
//==========================================================================================
	public String getFullName() {
		return fullName;
	}
}