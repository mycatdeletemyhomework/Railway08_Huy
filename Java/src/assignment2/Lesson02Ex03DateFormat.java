package assignment2;

import assignment1.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Lesson02Ex03DateFormat {
public static void main(String[] args) {
	// ===============================================================================================	
	Exam exam1 = new Exam();
	exam1.id = 1;
	exam1.code = "Railway 08";
	exam1.title = "Java basic";
	exam1.createDate = new Date("2019/03/08");
	// ===============================================================================================	
	
//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định	dạng vietnamese
	Locale locale = new Locale("vi", "VN");
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
	String examCreateDate = dateFormat.format(exam1.createDate);
	System.out.printf("Exam 1: %s - %s - %s ", exam1.code, exam1.title, examCreateDate);

//	Question 2:
//	In ra thông tin: Exam đã tạo ngày nào theo định dạng
//	Năm – tháng – ngày – gi�? – phút – giây
	String pattern = "yyyy-dd-MM-HH-mm-ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String examCreateDate2 = simpleDateFormat.format(exam1.createDate);
	System.out.printf("%n%s", examCreateDate2);
	
//	Question 3:
// 	Chỉ in ra năm của create date property trong Question 2
	String pattern1 = "yyyy";
	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);
	String examCreateDate3 = simpleDateFormat1.format(exam1.createDate);
	System.out.printf("%n%s", examCreateDate3);
	
//	Question 4:
//	Chỉ in ra tháng và năm của create date property trong Question 2
	String pattern2 = "MM-yyyy";
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
	String examCreateDate4 = simpleDateFormat2.format(exam1.createDate);
	System.out.printf("%n%s", examCreateDate4);
	
//	Question 5:
//	Chỉ in ra "MM-DD" của create date trong Question 2
	String pattern3 = "MM-dd"; // DD là day in year
	SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
	String examCreateDate5 = simpleDateFormat3.format(exam1.createDate);
	System.out.printf("%n%s", examCreateDate5);
}
}
