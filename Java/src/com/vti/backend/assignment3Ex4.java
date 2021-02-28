package com.vti.backend;

import java.util.Scanner;

public class assignment3Ex4 {
//==========================================================================================
public void question41() {
//	Question 1:
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng )
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter the string here: ");
	String s = scanner.nextLine();
	String sRefined = wordsRefinement(s);
	System.out.println("The word count of this line is: " + wordCounts(sRefined));
}
public String wordsRefinement(String s) {
	//	remove the spaces at the beginning and the end of the string
	s = s.trim();
		
	//	remove multiple spacing - for more information check trim() regex
	s = s.trim().replaceAll(" +", " ");
	
	return s;
}
public int wordCounts (String s) {
	String[] split = s.split(" ");
	return split.length;
}
//==========================================================================================
public void question42() {
//	Question 2:
//	Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
	Scanner scanner = new Scanner(System.in);
	System.out.printf("Please enter the first string here: ");
	String s1 = scanner.nextLine();
	System.out.printf("Please enter the second string here: ");
	String s2 = scanner.nextLine();
	String s = s1.concat(s2); // can simply use String s = s1 + s2;
	System.out.println(s);
}
//==========================================================================================
public void question43() {
//	Question 3:
//	Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//	viết hoa chữ cái đầu thì viết hoa lên
	Scanner scanner = new Scanner(System.in);
	System.out.printf("Please enter name here: ");
	String s = scanner.nextLine();
	s = s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	System.out.println(s);
}
//==========================================================================================
public void question44() {
//	Question 4:
//	Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//	VD:	Người dùng nhập vào "Nam", hệ thống sẽ in ra
//		"Ký tự thứ 1 là: N"
//		"Ký tự thứ 2 là: A"
//		"Ký tự thứ 3 là: M
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter user name here: ");
	String a = scanner.nextLine();
	for (int i = 0; i < a.length(); i++) {
		System.out.printf("%nThe %d letter is: %s", i+1, a.charAt(i));
	}
}
//==========================================================================================
public void question45() {
//	Question 5:
//	Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//	dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter user family name here: ");
	String familyName = scanner.nextLine();
	System.out.printf("%nPlease enter user first name here: ");
	String firstName = scanner.nextLine();
	String fullName = familyName + " " + firstName;
	System.out.println("Full name of the user is: " + fullName);
}
//==========================================================================================
public void question467() {
//	Question 6:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//	VD:	Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"
	
//	Question 7:
//	Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
//	a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập	vào
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn nam" 
//	b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
//	> question43()
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter user full name here: ");
	String s = scanner.nextLine();
	
	//	first, we need to refine the input
	s = wordsRefinement(s);
	
	//	then split the refined string to individual words
	String[] split = s.split(" ");

	//	upper case first letters of each letters
	for (int i = 0; i < split.length; i++) {
		split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
	}
	
	//	the last string of split array is first name, the first string is family name	
	System.out.println("Family name: " + split[0]);
	if (split.length <= 2) {
		System.out.print("This person doesn't have middle name!");
	} else {
		System.out.print("Middle name: ");
		for (int i = 1; i < split.length - 1; i++) {
			System.out.print(split[i] + " ");
		}
	}
	System.out.println("\nFirst name: " + split[split.length -1]);
}
//==========================================================================================
public void question48() {
	// TODO 
	// this question can be done using contain() or indexOf()
}
//==========================================================================================
public void question49() {
	// TODO 
}
//==========================================================================================
public void question410() {
//	Question 10:
//	Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không. Nếu có xuất ra “OK” ngược lại “KO”.
//	Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
//	similar to check if a string is Palindrome
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter first string here: ");
	String s1 = scanner.nextLine();
	System.out.print("Please enter second string here: ");
	String s2 = scanner.nextLine();
	
	boolean isReversed = true;
	
	if (s1.length() == s2.length()) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(s2.length()-i-1)) {
				isReversed = false;
				break;
			}
		}
	} isReversed = false;
	
	if (isReversed == true) {
		System.out.println("OK");
	} else {
		System.out.println("KO");
	}
}
//==========================================================================================
public void question415() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter string here: ");
	String s = scanner.nextLine();
	
	//	remove space at the beginning and the end, multiple spacing
	s = wordsRefinement(s);
	
	String[] split = s.split("\\s");
	String temp = "";

	for (int i = split.length - 1; i >= 0; i--) {
		temp += split[i] + " ";
	}
System.out.println(temp);
}
}
