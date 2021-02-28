package com.vti.backend;

public class assignment3Ex3 {
//==========================================================================================
public void question31() {
//	Question 1:
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
	Integer a = 5000;
	float b = a.floatValue();	
	System.out.printf("%n%.2f", b);
}
//==========================================================================================
public void question32() {
//	Question 2:
//	Khai báo 1 String có value = "1234567"
//	Hãy convert String đó ra số int
	String a = "1234567";
	int b = Integer.valueOf(a);
	int c = Integer.parseInt(a);
	System.out.printf("%n%d %d", b, c);
	
//	valueOf returns a new or cached instance of java.lang.Integer
//	parseInt returns primitive int.
//	The same is for all cases: Short.valueOf/parseShort, Long.valueOf/parseLong, etc.
}
//==========================================================================================
public void question33() {
//	Question 3:
//	Khởi tạo 1 số Integer có value là chữ "1234567"
//	Sau đó convert số trên thành datatype int
	Integer a = Integer.valueOf("1234567");
	int b = a.intValue();
	System.out.printf("%n%d", b);
}
}
