package testing_system;

public class Lesson02Ex01SwitchCase {
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
		
		// import account to groups
		Account[] membersOfGroup1 = {account1, account2};
		group1.members = membersOfGroup1;
		
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//	Còn lại in ra "Nhóm có nhiều thành viên"
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
		
//	Sử dụng switch case để làm lại Question 2
		
//	Sử dụng switch case để làm lại Question 4
		switch(account1.position.name) {
		case "Dev":
			System.out.println("Người này là developer");
			break;
		default:
			System.out.println("Người này không phải developer");
			break;
		}

		
}
}
