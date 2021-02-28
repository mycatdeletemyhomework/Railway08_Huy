package com.vti.backend;

import java.util.Random;
import java.util.Scanner;

public class assignment3Ex1 {
//==========================================================================================	
public void question11() {
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

	System.out.printf("Account1 (int): %d, Account2 (int): %d", account1int, account2int);
}
//==========================================================================================	
public String question12() {
//	Ex2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
	Random random = new Random();
	int a = random.nextInt(99999) + 1;
	String as = String.format("%05d", a);
	return as;
}
//==========================================================================================
public void question13() {
//	Ex3: Lấy 2 số cuối của số ở Question 2 và in ra.
//	chèn Question2 cho đỡ messup
	
	Random random = new Random();
	int a = random.nextInt(99999) + 1;
	String as = String.format("%05d", a);
	
//	Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối, using substring(int beginIndex)
	String as1 = as.substring(as.length() - 2);
	System.out.printf("%n%s", as1);
	
//	Cách 1: chia lấy dư cho 100
	int a1 = a % 100;
	String a1s = String.format("%02d", a1);
	System.out.printf("%n%s", a1s);
}
//==========================================================================================
public void question14() {
	Scanner scanner = new Scanner(System.in);
	System.out.printf("%nNhập vào số a: ");
	int a = scanner.nextInt();
	System.out.printf("%nNhập vào số b: ");
	int b = scanner.nextInt();
	float c = (float) a/b;
	System.out.printf("Thương của 2 số là: %.2f",c);
}
}
