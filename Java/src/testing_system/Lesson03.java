package testing_system;

import java.util.Date;

public class Lesson03 {
public static void main(String[] args) {
		
//==========================================================================================
//	Ex1:
//	Question 1:
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

	float account1 = 5240.5f;
	float account2 = 10970.055f;
	int account1int = (int) account1;
	int account2int = (int) account2;

	System.out.printf("%nAccount1 (int): %d, Account2 (int): %d", account1int, account2int);
	
//==========================================================================================
//	Ex2:
//	Question 1:
//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	Email: "Email 1"
//	Username: "User name 1"
//	FullName: "Full name 1"
//	CreateDate: now
	
	Account[] accounts = new Account[5];
	for (int i = 0; i < accounts.length; i++)
	{
		accounts[i] = new Account();
		accounts[i].email = "Email: " + i;
		accounts[i].userName = "User name: " + i;
		accounts[i].fullName = "Full name: " + i;
		accounts[i].createDate = new Date();
		System.out.printf("%n%s - %s - %s - %s", accounts[i].email, accounts[i].userName, accounts[i].fullName, accounts[i].createDate);
	}
	
	
	}	
}

