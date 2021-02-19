package assignment2;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Lesson02Ex04RandomNumber {
public static void main(String[] args) {
	Random random = new Random();
//	Question 1: In ngẫu nhiên ra 1 số nguyên
	int a = random.nextInt();
	System.out.println(a);
	
//	Question 2: In ngẫu nhiên ra 1 số thực 
	float b = random.nextFloat();
	System.out.println(b);

//	Question 3: Khai báo 1 array bao gồm các tên của các bạn trong lớp, 
//	sau đó in ngẫu nhiên ra tên của 1 bạn	
	String ten[] = {"Nathan", "Irene", "Ivy", "Lana", "Daniel"};
	int c = random.nextInt(ten.length);
	System.out.println(ten[c]);
	
//	Question 4: Lấy ngẫu nhiên 1 ngày trong khoảng th�?i gian 24-07-1995 tới ngày 20-12-1995
	// v�? cơ bản chỉ là đổi giá trị ngày thành số int (EpochDay) rồi random
	int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
	int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
	long randomInt = minDay + random.nextInt(maxDay - minDay);
	LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
	System.out.println(randomDay);

//	Question 5: Lấy ngẫu nhiên 1 ngày trong khoảng th�?i gian 1 năm trở lại đây
	Date toDay = new Date();
	int toDayInt = (int) LocalDate.now().toEpochDay();
	long randomInt2 = toDayInt - random.nextInt(365);
	LocalDate randomDay2 = LocalDate.ofEpochDay(randomInt2);
	System.out.println(randomDay2);
	
//	Question 6: Lấy ngẫu nhiên 1 ngày trong quá khứ (làm tương tự Question 5 nhưng với randomInt lớn hơn)
	
//	Question 7: Lấy ngẫu nhiên 1 số có 3 chữ số
	int d = random.nextInt(999 - 100 + 1) + 100;
	System.out.println(d);
	

	
	
}
}
