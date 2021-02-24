package assignment1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	public short id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public Date createDate;
	public Group[] groups;

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
		
//==========================================================================================
	@Override
	public String toString() {
		return id + " " + email + " " + userName + " " + fullName + " " + position + " " + createDate;
	}
//==========================================================================================		
}