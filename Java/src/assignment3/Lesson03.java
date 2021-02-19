package assignment3;

import assignment1.Account;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Lesson03 {
public static void main(String[] args) {
question46();
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
	String a = scanner.nextLine();
	System.out.println("The word count of this line is: " + wordCount(a));
	System.out.println("Disclamer: If user pressed double-space between letters, the result will be wrong!");
}
public static int wordCount(String s) {
	int count = 0;
	
	// first, we need to remove all of the spacing at the start and the end of the string, only stop when all of them removed
	while (true) {
	if (s.charAt(0) == ' ') { 
		s = s.substring(1); // eliminate the space at the beginning string
	}
	if (s.charAt(s.length()-1) == ' ') { 
		s = s.substring(0, s.length() - 1); // eliminate the space at the beginning and the end of string
	}
	if (s.charAt(0) != ' ' && s.charAt(s.length()-1) != ' ')
		break;
	}
	
	// then we will count number of the worlds when meet a space
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') { //charAt(i) == " " will show an error
				count++; // count the number of space
			}
		}
	
	count += 1; // number of letter = number of space +1
	return count;
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
public static void question46() {
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
//	> question41() and question46()
	
//	b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"
//	> question43()
//	Disclamer: this function won't work if user's middle name is more than 2-letter long!
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter user full name here: ");
	String s = scanner.nextLine();
	
	// first, we need to remove all of the spacing at the start and the end of the string, only stop when all of them removed
	while (true) {
	if (s.charAt(0) == ' ') { 
		s = s.substring(1); // eliminate the space at the beginning string
	}
	if (s.charAt(s.length()-1) == ' ') { 
		s = s.substring(0, s.length() - 1); // eliminate the space at the beginning and the end of string
	}
	if (s.charAt(0) != ' ' && s.charAt(s.length()-1) != ' ')
		break;
	}
		
	// at here, we will cut the String full name from the beginning: first letter is the family name
	// following by a cut from the back: last letter is the first name
	// lastly, the middle part (which have been left is the middle name)

	String s1 = "";
	String middleName = "";
	String familyName = "";
	String firstName = "";
	
	// cut out family name
	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == ' ') {
			familyName = s.substring(0, i);
			s1 = s.substring(i + 1);
			break;
		}
	}
	
	// separate first name and middle name
	for (int i1 = s1.length() - 1; i1 >= 0; i1--) { // charAt indexing start with 0 but length() will count from 1
		if (s1.charAt(i1) == ' ') {
			firstName = s1.substring(i1+1);
			middleName = s1.substring(0, i1);
			break;
		}
	}
	
	familyName = familyName.substring(0,1).toUpperCase() + familyName.substring(1).toLowerCase();
	middleName = middleName.substring(0,1).toUpperCase() + middleName.substring(1).toLowerCase();
	firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
	
	System.out.println("Family name: " + familyName);
	System.out.println("Midlle name: " + middleName);
	System.out.println("First name: " + firstName);
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
}

