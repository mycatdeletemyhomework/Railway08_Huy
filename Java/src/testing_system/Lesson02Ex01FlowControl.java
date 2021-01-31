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
	account2.fullName = "Nguyen Van 2";
	Group[] groupOfAccount2 = {group1, group2}; // create the array containt groups of account 2
	account2.department = department2;
	account2.groups = groupOfAccount2;
	
	Account account3 = new Account();
	account3.userName = "nguyenvan3";
	account3.position = position1;
		
//	Kiểm tra account thứ 2
//	Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//	"Nhân viên này chưa có phòng ban"
//	Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
	if (account2.department == null) {System.out.println("Nhân viên này chưa có phòng ban");}
	else {System.out.println("Phòng ban của nhân viên này là: " + account2.department.name);}
	
//	Kiểm tra account thứ 2
//	Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//	Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//	Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//	Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
	if (account2.groups.length == 0) {System.out.println("Nhân viên này chưa có group");}
	else if (account2.groups.length == 1 || account2.groups.length == 2) {System.out.println("Nhân viên này chưa có group");}
	else if (account2.groups.length == 3) {System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");}
	else {System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");}
// ủa đhs sai?
	
//	Sử dụng toán tử ternary để làm Question 1
	System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là: " + account2.department.name);
	

//	Sử dụng toán tử ternary để làm yêu cầu sau:
//	Kiểm tra Position của account thứ 1
//	Nếu Position = Dev thì in ra text "Đây là Developer"
//	Nếu không phải thì in ra text "Người này không phải là Developer"
	System.out.println(account1.position.name == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	}
}
