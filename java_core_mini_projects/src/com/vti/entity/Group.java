package com.vti.entity;

import java.util.Date;

public class Group {
	private short id;
	private String name;
	private Account creator;
	private Date createDate;
	private Account[] members;

//==========================================================================================
//	create constructors

//	with no parameter
	public Group() {
	}

//	parameters: GroupName, Creator, array Account[] accounts, CreateDate
	public Group(String name, Account creator, Account[] members, Date createDate) {
		this.name = name;
		this.creator = creator;
		this.members = members;
		this.createDate = createDate;
	}

//	parameters: GroupName, Creator, array String[] usernames , CreateDate
//	with each username input here, create a new Account (with only username, other data = null)
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
		String s = "";
		String s1= "";
		if (members == null) {
			s1 = "This group is empty";
		} else {
			for (Account account : members) {
				s1 += account.userName + " ";
		}
		}
		s = "Group ID: " + id + " Members: " + s1 ;
		return s;
	}
}
