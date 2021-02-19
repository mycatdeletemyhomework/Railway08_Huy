import java.util.Random;
import java.util.Scanner;

public class randomApp {
	// config
	static short soDe;
	static int taiKhoan = 1000;
	static int soTienDanhDe;
	static int tiGiaDe = 70;
	
	// config giai
	static int[] giai7 = new int[4]; // "static int[4] giai 7;" will show as syntax error
	static int[] giai6 = new int[3];
	static int[] giai5 = new int[8];
	static int[] giai4 = new int[4];
	static int[] giai3 = new int[6];
	static int[] giai2 = new int[2];
	static int giai1;
	static int giaiDacBiet;
	
	// giai de
	static boolean resultDe;
	
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	while (true) {
	System.out.println("Xin mời chọn tính năng: ");	
	System.out.printf("1.Đánh đề\n2.Đánh lô\n3.Thoát chương trình");
	short i = scanner.nextShort(); //short i phải ở trong while true thì vòng lặp lại mới liên tục sau mỗi lần sử dụng function
	switch(i) {
	case 1:
		danhDe();
		break;
	case 2:
		break;
	case 3:
		System.out.println("Thoát chương trình, hẹn gặp bạn lần sau!!");
		return;
	default:
		System.out.println("Chọn sai, vui lòng chọn lại.");
		break;
		
	}
	}
}

public static void danhDe() {
	Scanner scanner = new Scanner(System.in);
	while (true) {
	System.out.println("Xin mời nhập số bạn chọn: ");
	short soDeTemp = scanner.nextShort();
	if (01 <= soDeTemp && 99 >= soDeTemp) {
		soDe = soDeTemp;
		break;
	} else {
	System.out.println("Nhập sai, nhập lại.");
	}
}
	
	while (true) {
	System.out.println("Mời nhập số tiền bạn muốn đánh (đơn vị ngàn đồng): ");
	int soTienDanhDeTemp = scanner.nextInt();
	if (soTienDanhDeTemp <= taiKhoan) {
		soTienDanhDe = soTienDanhDeTemp;
		taiKhoan -= soTienDanhDe;
	} else {
		System.out.println("Tài khoản không đủ tiền để đánh mức này!");
	}
	}
	
	randomGiai();
	resultDe = checkDe();
	if (resultDe == true) {
		System.out.println("Chúc mừng bạn đã ăn đề");
		taiKhoan += soTienDanhDe * tiGiaDe;
	} else {
		System.out.println("Rất tiếc bạn đánh không trúng");
	}
//	inGiai();
	System.out.printf("Số dư tài khoản hiện tại: %d\n", taiKhoan);
}

public static void randomGiai() {
	Random random = new Random();
	
//	giaiDacBiet = random.nextInt(100000);
	giaiDacBiet = 12365;
	
	giai1 = random.nextInt(100000);
	
	for (int i = 0; i < giai2.length; i++) {
		giai2[i] = random.nextInt(100000);
	}
	
	for (int i = 0; i < giai3.length; i++) {
		giai3[i] = random.nextInt(100000);
	}
	
	for (int i = 0; i < giai4.length; i++) {
		giai4[i] = random.nextInt(10000);
	}
	
	for (int i = 0; i < giai5.length; i++) {
		giai5[i] = random.nextInt(10000);
	}
	
	for (int i = 0; i < giai6.length; i++) {
		giai6[i] = random.nextInt(1000);
	}
	
	for (int i = 0; i < giai7.length; i++) {
		giai7[i] = random.nextInt(100);
	}

}

public static void inGiai() {
	// giai dac biet
	System.out.printf("%18s\n", String.format("%05d", giaiDacBiet)); // format lenh print ra la 5 so cho du random ra so co 4 chu so
	
	// giai 1
	System.out.printf("%18s\n", String.format("%05d", giai1));
	
	// giai 2
	for (int i : giai2) {
		System.out.printf("%11s", String.format("%05d", i));
	}
	System.out.printf("\n");

	// giai 3
	for (int i : giai3) {
		System.out.printf("%10s", String.format("%05d", i));
	}
	System.out.printf("\n");
	
	//giai 4
	for (int i : giai4) {
		System.out.printf("%9s", String.format("%04d", i));
	}
	System.out.printf("\n");
	
	// giai 5
	for (int i : giai5) {
		System.out.printf("%5s", String.format("%04d", i));
	}
	System.out.printf("\n");
	
	// giai 6
	for (int i : giai6) {
		System.out.printf("%10s", String.format("%03d", i));
	}
	System.out.printf("\n");
	
	// giai 7
	for (int i : giai7) {
		System.out.printf("%7s", String.format("%02d", i));
	}
	System.out.printf("\n");
}

public static boolean checkDe() {
	if (soDe == giaiDacBiet % 100) {
		return true;
	}
	else return false;
}

}
