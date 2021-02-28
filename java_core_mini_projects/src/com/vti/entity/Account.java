package com.vti.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	private short id;
	private String email;
	public String userName;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	private Group[] groups;

//==========================================================================================
//	create constructors

//	with no parameter
	public Account() {
	}

//	with Username
	public Account(String userName) {
		this.userName = userName;
	}
	
//	parameters: id, Email, Username, FirstName, LastName (FullName = FirstName + LastName)
	public Account(short id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
	}

//	parameters: id, Email, Username, FirstName, LastName (FullName = FirstName + LastName), Position, default createDate = now
	public Account(short id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = new Date();
	}

//	parameters: id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName), Position, createDate
	public Account(short id, String email, String userName, String firstName, String lastName, Position position,
			Date createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}

//==========================================================================================
	@Override
	public String toString() {
		return id + " " + email + " " + userName + " " + fullName + " "
				+ (position != null ? position.name : "|Position is null|") + " " + createDate;
	}
//==========================================================================================
}