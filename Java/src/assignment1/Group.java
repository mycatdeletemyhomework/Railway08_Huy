package assignment1;

import java.util.Date;

public class Group {
	public short id;
	public String name;
	public Account creator;
	public Date createDate;
	public Account[] members;
	
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
		// ??
		this.createDate = createDate;
	}
}
