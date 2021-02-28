package com.vti.backend;

import java.util.Date;

import com.vti.entity.Account;

public class assignment3Ex2 {
public static void main(String[] args) {
}
public void question21() {
//	Ex2:
//	Question 1:
//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	Email: "Email 1"
//	Username: "User name 1"
//	FullName: "Full name 1"
//	CreateDate: now
	
	Account[] accounts = new Account[5]; // mới chỉ khai báo 1 array có 5 con chỏ
	for (int i = 0; i < accounts.length; i++)
	{
		//	edited: for create object with private entities, using constructor
		accounts[i] = new Account((short) 1, "account1@gmail.com", (String) ("User name" + i), "First name", "Last Name 1");
		System.out.println(accounts[i].toString()); // prior to: all entities in "Account" class is private, toString returned blank
	}
}
}
