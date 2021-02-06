package testing_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson02Ex05InputFromConsole {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
//	Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình	
	int[] a = new int[3]; //to successfully initialize array, we need to have the size of the array
	for (int i = 0; i < 3; i++)
	{
		System.out.printf("%nMời nhập số thứ %d: ", i+1);
		a[i] = scanner.nextInt();
	}
	System.out.printf("%nCác số đã nhập là: ");
	for (int i = 0; i < 3; i++)
	{
		System.out.printf(" %d ", a[i]);
	}
	
//	Question 1: Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình	(using list)
	List<Integer> b = new ArrayList<Integer>(); // with out the size, we can initialize a list and then use list.add
	for (int i = 0; i < 3; i++)
	{
		System.out.printf("%nMời nhập số thứ %d: ", i+1);
		b.add(scanner.nextInt());
	}	
	System.out.println("Các số đã nhập là" + b.toString());
	
//	Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
	float[] c = new float[2];
	for (int i = 0; i < 2; i++)
	{
		System.out.printf("%nMời nhập số thứ %d: ", i+1);
		c[i] = scanner.nextFloat();
	}
	System.out.printf("%nCác số đã nhập là: ");
	for (int i = 0; i < 2; i++)
	{
		System.out.printf(" %.1f ", c[i]);
	}
	
	
//	Question 4: Viết lệnh cho phép người dùng nhập họ và tên
	System.out.printf("%nMời nhập họ: ");
	String ho = scanner.next(); // scanner.nextLine won't do it
	System.out.printf("%nMời nhập tên: ");
	String ten = scanner.next();
	System.out.printf("Họ và tên là: %s %s", ho, ten);
//	next() can read the input only till the space. It can't read two words separated by space. 
//	Also, next() places the cursor in the same line after reading the input.
//	nextLine() reads input including space between the words (that is, it reads till the end of line).
//	Once the input is read, nextLine() positions the cursor in the next line.
	
//	Question 5: 	
//	Viết lệnh cho phép người dùng tạo account (viết thành method)
//	Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//	chương trình sẽ chuyển thành Position.Dev, Position.Test,
//	Position.ScrumMaster, Position.PM
	createAccount(); // see method createAccount below
	
//	Question 6: Viết lệnh cho phép người dùng tạo department (viết thành method)
	createDepartment(); // see method createDepartment below
	
//	Question 7: Nhập số chẵn từ console
	while (true) // vòng lặp liên tục cho đến khi break > tức là nhập đã đúng
	{
	System.out.printf("%nMời nhập số: ");
	int d = scanner.nextInt();
	if (d % 2 == 1)
		{
		System.out.printf("%nNhập sai, mời nhập lại!");
		}
	else
		{
		System.out.println("Số chẵn nhập hợp lệ là: " + d );
		break;
		}
	};
	
//	Question 8: Viết chương trình thực hiện theo flow sau:
//	Bước 1:
//		Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
//	Bước 2:
//		Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//		Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
//		Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1	
	while (true) // vòng lặp liên tục cho đến khi break > tức là nhập đã đúng
	{
		System.out.printf("%nMời bạn nhập vào chức năng muốn sử dụng: ");
		int i = scanner.nextInt();
		
		switch (i) {
		case 1:
			createAccount();
			return; // why is break not wotking in this case???
		case 2:
			createDepartment();
			return;
		default:
			System.out.printf("%nMời nhập lại!");
		}
	}
	
//	Question 9: Viết method cho phép người dùng thêm group vào account theo flow sau:
//	Bước 1: In ra tên các usernames của user cho người dùng xem
//	Bước 2: Yêu cầu người dùng nhập vào username của account
//	Bước 3:	In ra tên các group cho người dùng xem
//	Bước 4:	Yêu cầu người dùng nhập vào tên của group
//	Bước 5:	Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó
	
//	Question 10:
//	Bổ sung thêm vào bước 2 của Question 8 như sau:
//		Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
//	Bổ sung thêm Bước 3 của Question 8 như sau:
//		Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng
//		text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác
//		không?". 
//		Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người
//		dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để
//		kết thúc chương trình)
	
//	Question 11:
//	Bổ sung thêm vào bước 2 của Question 8 như sau:
//	Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
//		Bước 1:	In ra tên các usernames của user cho người dùng xem
//		Bước 2:	Yêu cầu người dùng nhập vào username của account
//		Bước 3:	Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
//		Bước 4:	Thêm account vào group chương trình vừa chọn ngẫu nhiên


}	
public static void createAccount() 
{
	Scanner scanner = new Scanner(System.in);
	
	System.out.printf("%nNhập vào id của account: ");
	short id = scanner.nextShort();
	
	System.out.printf("%nNhập vào username của account: ");
	String userName = scanner.next();
	
	System.out.printf("%nNhập vào mã position (mã position hợp lệ từ 1 -> 5): ");
	short positionId = scanner.nextShort();
	String positionName;
	switch (positionId)
	{
	case 1:
		positionName = "Position.Dev";
		break;
	case 2:
		positionName = "Position.Test";
		break;
	case 3:
		positionName = "Position.ScrumMaster";
		break;
	case 4:
		positionName = "Position.PM";
		break;
	default:
		positionName = "Waiting";
	}
	
	System.out.printf("%nThông tin của account: %d - %s - %s", id, userName, positionName);
}

public static void createDepartment()
{
	Scanner scanner = new Scanner(System.in);
	
	System.out.printf("%nNhập vào id của department: ");
	short id = scanner.nextShort();
	scanner.nextLine(); // to consumer the %n that previous scanner make > therefore scanner.nextLine is usable
	
	System.out.printf("%nNhập vào tên của department: ");
	String departmentName = scanner.nextLine();
	
	System.out.printf("%nThông tin của department: %d - %s", id, departmentName);
	
}

}