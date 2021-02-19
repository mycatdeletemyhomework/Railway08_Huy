package assignment2;

import assignment1.*;

import java.util.Date;
import java.util.Locale;

public class Lesson02Ex02SystemOutPrintf {
public static void main(String[] args) {
// ===============================================================================================	
	// create new deparments
	Department department1 = new Department();
	department1.id = 1;
	department1.name = "Sale";
	
	Department department2 = new Department();
	department2.id = 2;
	department2.name ="Marketing";
	
	Department department3 = new Department();
	department3.id = 3;
	department3.name = "Project";
	
	// create new groups
	Group group1 = new Group();
	group1.id = 1;
	group1.name = "Java Fresher";
	
	Group group2 = new Group();
	group2.id = 2;
	group2.name = "C# Fresher";
	
	Group group3 = new Group();
	group3.id = 3;
	group3.name = "PHP Fresher";
	
	// create new positions
	Position position1 = new Position();
	position1.id = 1;
	position1.name = "Dev";
	
	Position position2 = new Position();
	position2.id = 1;
	position2.name = "TM";
	
	Position position3 = new Position();
	position3.id = 1;
	position3.name = "Testers";
	
	// create new accounts
	Account account1 = new Account();
	account1.id = 1;
	account1.email = "nguyenvan1@gmail.com";
	account1.position = position1;
	account1.department = department1;
	
	Account account2 = new Account();
	account2.id = 2;
	account2.fullName = "Nguyen Van 2";
	Group[] groupOfAccount2 = {group1, group2}; // create the array containt groups of account 2
	account2.department = department2;
	account2.groups = groupOfAccount2;
	
	Account account3 = new Account();
	account3.id = 3;
	account3.userName = "nguyenvan3";
	account3.position = position1;
	account3.department = department3;
// ===============================================================================================		
	
//	 Question 1: Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số	nguyên đó
	int a = 5;
	System.out.printf("%d", a);
	
//	Question 2: Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//	ra số nguyên đó thành định dạng như sau: 100,000,000
	int b = 100000000;
	System.out.printf(Locale.US, "%n%,d", b);
	
//	Question 3:
//	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//	thực đó chỉ bao gồm 4 số đằng sau
	
	float c = 5.567098f;
	System.out.printf("%n%.4f", c);
	
//	Question 4:	
//	Khai báo H�? và tên của 1 h�?c sinh và in ra h�? và tên h�?c sinh đó theo định dạng như sau:
//	H�? và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//	Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	String d = "Nguyễn Văn A";
	System.out.printf("%nTên tôi là %s và tôi đang độc thân.", d);
	
//	Question 5:
//	Lấy th�?i gian bây gi�? và in ra theo định dạng sau:
//	24/04/2020 11h:16p:20s 
	Date date = new Date();
	System.out.printf("%n%1$td/%1$tm/%1$tY %1$tHh:%1$tMp:%1$tSs", date);
	
//	Question 6:
//	In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//	table (giống trong Database)
	System.out.printf("%n%20s| %20s| %20s", "Email", "Tên", "Department");
	Account[] accounts = {account1, account2, account3};
	for (Account account : accounts)
	{
		System.out.printf("%n%20s| %20s| %20s", account.email, account.fullName, account.department.name);
	}
	
	
}
}
