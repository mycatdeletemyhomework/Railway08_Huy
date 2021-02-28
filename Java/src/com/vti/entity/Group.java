package com.vti.entity;

import java.util.Date;

import assignment1.Account;

public class Group {
	private short id;
	private String name;
	private Account creator;
	private Date createDate;
	private Account[] members = new Account[100];
	
//==========================================================================================
//	this added prior to Lesson 4 - exercise 1 - question 2
//	Question 3:
//	Tạo constructor cho Group:
//	a) không có parameters
	public Group() {
	}
	
//	b) Có các parameter là GroupName, Creator, array Account[] accounts, CreateDate
	public Group(String name, Account creator, Account[] members, Date createDate) {
		this.name = name;
		this.creator = creator;
		this.members = members;
		this.createDate = createDate;
	}
	
//	c) Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//	Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các thông tin còn lại = null)
	public Group(String name, Account creator, String[] userNames, Date createDate) {
		this.name = name;
		this.creator = creator;
		
		members = new Account[userNames.length];
		for (int i = 0; i < members.length; i++) {
			members[i] = new Account(userNames[i]);
		}
	
		this.createDate = createDate;
	}
	
//==========================================================================================
	@Override
	public String toString() {
		return id + " " + name + " " + (creator != null ? creator.fullName : "|There is no creator of this group|") + " " + createDate;
	}
}
