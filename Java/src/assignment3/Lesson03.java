package assignment3;

import assignment1.Account;
import assignment1.Department;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lesson03 {
public static void main(String[] args) {
question415();
}
		
//==========================================================================================
public static void question11() {
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
public static String question12() {
//	Ex2: Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//	có số 0 ở đầu cho đủ 5 chữ số)
	Random random = new Random();
	int a = random.nextInt(99999) + 1;
	String as = String.format("%05d", a);
	return as;
}
//==========================================================================================
public static void question13() {
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
public static void question14() {
	Scanner scanner = new Scanner(System.in);
	System.out.printf("%nNhập vào số a: ");
	int a = scanner.nextInt();
	System.out.printf("%nNhập vào số b: ");
	int b = scanner.nextInt();
	float c = (float) a/b;
	System.out.printf("Thương của 2 số là: %.2f",c);
}
//==========================================================================================
public static void question21() {
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
		accounts[i] = new Account(); // cái này quan trọng do nó khởi tạo đối tượng (object)
		accounts[i].email = "Email: " + i;
		accounts[i].userName = "User name: " + i;
		accounts[i].fullName = "Full name: " + i;
		accounts[i].createDate = new Date();
		System.out.printf("%n%s - %s - %s - %s", accounts[i].email, accounts[i].userName, accounts[i].fullName, accounts[i].createDate);
	}
}
//==========================================================================================
public static void question31() {
//	Question 1:
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)
	Integer a = 5000;
	float b = a.floatValue();	
	System.out.printf("%n%.2f", b);
}
//==========================================================================================
public static void question32() {
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
public static void question33() {
//	Question 3:
//	Khởi tạo 1 số Integer có value là chữ "1234567"
//	Sau đó convert số trên thành datatype int
	Integer a = Integer.valueOf("1234567");
	int b = a.intValue();
	System.out.printf("%n%d", b);
}
//==========================================================================================
public static void question41() {
//	Question 1:
//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng )
	Scanner scanner = new Scanner(System.in);
	System.out.println("Please enter the string here: ");
	String s = scanner.nextLine();
	String sRefined = wordsRefinement(s);
	System.out.println("The word count of this line is: " + wordCounts(sRefined));
}
public static String wordsRefinement(String s) {
	//	remove the spaces at the beginning and the end of the string
	s = s.trim();
		
	//	remove multiple spacing - for more information check trim() regex
	s = s.trim().replaceAll(" +", " ");
	
	return s;
}
public static int wordCounts (String s) {
	String[] split = s.split(" ");
	return split.length;
}
//==========================================================================================
public static void question42() {
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
public static void question43() {
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
public static void question44() {
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
public static void question45() {
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
public static void question467() {
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
public static void question48() {
	// TODO 
	// this question can be done using contain() or indexOf()
}
//==========================================================================================
public static void question49() {
	// TODO 
}
//==========================================================================================
public static void question410() {
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
	}
	
	if (isReversed == true) {
		System.out.println("OK");
	} else {
		System.out.println("KO");
	}
}
//==========================================================================================
public static void question415() {
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
//==========================================================================================
public static void question567() { // sửa lại dùng compareTo ingore case
//	Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//	sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	Sale
//	Waiting room

	Department department1 = new Department();
	department1.id = 10;
	department1.name = "Accounting";
	
	Department department2 = new Department();
	department2.id = 2;
	department2.name = "Sale";
	
	Department department3 = new Department();
	department3.id = 3;
	department3.name = "Marketing";
	
	Department department4 = new Department();
	department4.id = 4;
	department4.name = "Waiting room";
	
	Department department5 = new Department();
	department5.id = 5;
	department5.name = "Boss of director";

//	List<Department> departments = new ArrayList<>();
//	departments.add(department1);
//	departments.add(department2);
//	departments.add(department3);
//	departments.add(department4);
//	departments.add(department5);
	
	Department[] departments = {department1, department2, department3, department4, department5};
	
	Collections.sort(Arrays.asList(departments));
	
	for (Department department : departments) {
		System.out.println(department);
	}
	
//	this part serve question57()
//	Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
//	sách phòng ban được sắp xếp theo tên
//	VD:
//	Accounting
//	Boss of (d)irector
//	Marketing
//	waiting (r)oom
//	Sale
//	READ ME: to use this function, toggle on/off comparator at Department class (there are 2 comparator definition for question56 and question57
//	the syntax in this method remained the same
}
//==========================================================================================
}

