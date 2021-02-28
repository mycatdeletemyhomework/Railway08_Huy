package com.vti.backend;

import assignment1.*;
import java.util.Date;

public class assignment4 {
	public static void main(String[] args) {
		question13();
	}

//==========================================================================================
	public static void question11() {
//	Question 1:
//	Tạo constructor cho department:
//	Khởi tạo 1 Object với mỗi constructor:
//	a) không có parameters
		Department department1 = new Department();
//	b) Có 1 parameter là nameDepartment và default id của Department = 0
		Department department2 = new Department("Accounting");

		System.out.println(department1.name);
		System.out.println(department2.id + " " + department2.name);
	}

//==========================================================================================
	public static void question12() {
//	Question 2:
//	Tạo constructor cho Account:
//	Khởi tạo 1 Object với mỗi constructor:

//	a) Không có parameters
		Account account1 = new Account();

//	b) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
		Account account2 = new Account((short) 2, "account2@gmail.com", "reginageorge", "Regina", "George");
//	need to cast the first number > (short) otherwise system will automatically recognize it as int > constructor is unidentified	

//	c) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, default createDate = now
		// create new position first
		Position position1 = new Position();
		position1.name = "Unidentified";

		// then create the object
		Account account3 = new Account((short) 3, "account3@gmail.com", "emmastone", "Emma", "Stone", position1);

//	d) Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và Position của User, createDate
		Account account4 = new Account((short) 4, "account4@gmail.com", "stevetrevor", "Steve", "Trevor", position1,
				new Date("2019/12/12"));

//	check
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		System.out.println(account3.toString());
		System.out.println(account4.toString());

	}

//==========================================================================================
	public static void question13() {
//	Question 3:
//	Tạo constructor cho Group:
//	Khởi tạo 1 Object với mỗi constructor:
//	a) không có parameters
		Group group1 = new Group();

//	b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
		// create new account for group creator
		Account account2 = new Account((short) 2, "account2@gmail.com", "reginageorge", "Regina", "George");

		// create object with this constructor
		Group group2 = new Group("Group 1", account2, new Account[] { account2 }, new Date(2020 / 12 / 12));

//	c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//	Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null)
		Group group3 = new Group("Group 3", account2, new String[] { "emmastone", "stevetrevor" },
				new Date(2020 / 11 / 11));

//	check
		System.out.println(group1.toString());
		System.out.println(group2.toString());
		System.out.println(group3.toString());
	}
//==========================================================================================
}
