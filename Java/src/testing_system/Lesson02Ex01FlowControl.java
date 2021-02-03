package testing_system;

public class Lesson02Ex01FlowControl {
public static void main(String[] args) {
	
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

//	Question 1:
//	Kiểm tra account thứ 2 .Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//	"Nhân viên này chưa có phòng ban". Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
	if (account2.department == null) {System.out.println("Nhân viên này chưa có phòng ban");}
	else {System.out.println("Phòng ban của nhân viên này là: " + account2.department.name);}

//	Question 2:
//	Kiểm tra account thứ 2. Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
	if (account2.groups.length == 0) {System.out.println("Nhân viên này chưa có group");}
	else if (account2.groups.length == 1 || account2.groups.length == 2) {System.out.println("Nhân viên này chưa có group");}
	else if (account2.groups.length == 3) {System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");}
	else {System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");}
// ủa đhs sai?
	
//	Question 3:	
//	Sử dụng toán tử ternary để làm Question 1
	System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là: " + account2.department.name);
	

//	Question 4:
//	Sử dụng toán tử ternary để làm yêu cầu sau:
//	Kiểm tra Position của account thứ 1
//	Nếu Position = Dev thì in ra text "Đây là Developer"
//	Nếu không phải thì in ra text "Người này không phải là Developer"
	System.out.println(account1.position.name == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	
// 	Question 5:
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//	Còn lại in ra "Nhóm có nhiều thành viên"
	Account[] membersOfGroup1 = {account1};
	group1.members = membersOfGroup1;
	
		switch(group1.members.length) {
		case 0:
			System.out.println("Nhóm không có thành viên");
			break;
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm nhiều ba thành viên");
			break;
		}
//	Question 6:
//	Sử dụng switch case để làm lại Question 2
		
//	Question 7:
//	Sử dụng switch case để làm lại Question 4
			switch(account1.position.name) {
			case "Dev":
				System.out.println("Người này là developer");
				break;
			default:
				System.out.println("Người này không phải developer");
				break;
			}
			
//	Question 8:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
	Account[] accounts = {account1, account2, account3};
	for (Account account  : accounts) // account chỉ là biến để tạo vòng lặp (vd như i ở các thí dụ khác) không cần là biến đã được declare ở trên
	{
		System.out.printf("%n	+Email của người có id = %d là: %s", account.id, account.email);
		System.out.printf("%n	 Tên đầy đủ của người có id = %d là: %s", account.id, account.fullName);
		System.out.printf("%n	 Department của người có id = %d là: %s", account.id, account.department.name);
	}
	
//	Question 9:
//	In ra thông tin các phòng ban bao gồm: id và name
	Department[] departments = {department1, department2, department3};
	for (Department department : departments)
	{
		System.out.printf("%nMã phòng ban: %d, tên phòng ban: %s", department.id, department.name);
	}
	
//	Question 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//	họ theo định dạng như sau:
//	Thông tin account thứ 1 là:
//	Email: NguyenVanA@gmail.com
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là:
//	Email: NguyenVanB@gmail.com
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting
	for (int i = 0; i < accounts.length; i++)
	{
		System.out.printf("%nThông tin account thứ %d là:", i+1);
		System.out.printf("%n	Email: %s", accounts[i].email);
		System.out.printf("%n	Full name: %s", accounts[i].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i].department.name);
	}
	
//	Question 11:
//	In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//	Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//	Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing
	for (int i = 0; i < departments.length; i++)
	{
		System.out.printf("%nThông tin department thứ %d là: ", i+1);
		System.out.printf("%n	ID: %d", departments[i].id);
		System.out.printf("%n	Name: %s", departments[i].name);
	}

//	Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10 (11 chứ?)
	for (int i = 0; i < 2; i++)
	{
		System.out.printf("%nThông tin department thứ %d là: ", i+1);
		System.out.printf("%n	ID: %d", departments[i].id);
		System.out.printf("%n	Name: %s", departments[i].name);
	}

//	Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2
	for (int i = 0; i < accounts.length; i++)
		if (i != 1)
	{
		System.out.printf("%nThông tin account thứ %d là:", i+1);
		System.out.printf("%n	Email: %s", accounts[i].email);
		System.out.printf("%n	Full name: %s", accounts[i].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i].department.name);
	};
	
//	Question 14: In ra thông tin tất cả các account có id < 4	
	for (int i = 0; i < 3; i++)
	{
		System.out.printf("%nThông tin account thứ %d là:", i+1);
		System.out.printf("%n	Email: %s", accounts[i].email);
		System.out.printf("%n	Full name: %s", accounts[i].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i].department.name);
	}
	
//	Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20
	System.out.println("\nQ15: ");
	for (int i = 0; i <= 20; i++)
		if (i % 2 == 0)
		{
			System.out.printf("%d ", i);
		}
//	Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
	//	Question 16-10:
	int i1 = 0;
	while (i1 < accounts.length)
	{
		System.out.printf("%nThông tin account thứ %d là:", i1+1);
		System.out.printf("%n	Email: %s", accounts[i1].email);
		System.out.printf("%n	Full name: %s", accounts[i1].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i1].department.name);
		i1++;
	}
	
	// Question 16-11:
	int i2 = 0;
	while (i2 < departments.length)
	{
		System.out.printf("%nThông tin department thứ %d là: ", i2+1);
		System.out.printf("%n	ID: %d", departments[i2].id);
		System.out.printf("%n	Name: %s", departments[i2].name);
		i2++;
	}
	
	// Question 16-13:
	int i3 = 0;
	while (i3 < accounts.length)
	{
		if (i3 == 1) {
			i3++;	//i3++ is compulsory, without this, the loop stop at i3 == 1
			continue;}
		System.out.printf("%nThông tin account thứ %d là:", i3+1);
		System.out.printf("%n	Email: %s", accounts[i3].email);
		System.out.printf("%n	Full name: %s", accounts[i3].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i3].department.name);
		i3++;
	}
	
	// Question 16-15:
	System.out.println("\nQ16-15: ");
	int i4 = 0;
	while (i4 <= 20)
	{
		if (i4 % 2 == 0)
		{
			System.out.printf("%d ", i4);
		}
	i4++;	
	}
	
	// Question 16-15: C2
	System.out.println("\nQ16-15: ");
	int i5 = 0;
	while (i5 <= 20)
		if (i5 % 2 == 0)
		{
			System.out.printf("%d ", i5);
			i5 += 2;
		}
	
//	Question 17:	
	// Question 17-10:
	int i6 = 0;
	do
	{
		System.out.printf("%nThông tin account thứ %d là:", i6+1);
		System.out.printf("%n	Email: %s", accounts[i6].email);
		System.out.printf("%n	Full name: %s", accounts[i6].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i6].department.name);
		i6++;
	} while (i6 < accounts.length);
	
	//Question 17-11:
	int i7 = 0;
	do 
	{
		System.out.printf("%nThông tin department thứ %d là: ", i7+1);
		System.out.printf("%n	ID: %d", departments[i7].id);
		System.out.printf("%n	Name: %s", departments[i7].name);
		i7++;
	} while (i7 < departments.length);
	
	// Question 17-13:
	int i8 = 0;
	do
	{
		if (i8 == 1) {
			i8++;	//i8++ is compulsory, without this, the loop stop at i3 == 1
			continue;}
		System.out.printf("%nThông tin account thứ %d là:", i8+1);
		System.out.printf("%n	Email: %s", accounts[i8].email);
		System.out.printf("%n	Full name: %s", accounts[i8].fullName);
		System.out.printf("%n	Phòng ban: %s", accounts[i8].department.name);
		i8++;
	} while (i8 < accounts.length);
	
	
	// Question 17-15:
	System.out.println("\nQ17-15: ");
	int i9 = 0;
	do
	{
		if (i9 % 2 == 0)
		{
			System.out.printf("%d ", i9);
		}
	i9++;	
	} while (i9 <= 20);
	
	}
}
