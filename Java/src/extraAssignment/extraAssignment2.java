package extraAssignment;

import java.util.Scanner;

public class extraAssignment2 {
public static void main(String[] args) {
	question11();
}
//==========================================================================================
public static void question11() {
//	Question 1:
//	Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet (cm).
//	Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch (số thực, có 2 số lẻ thập phân).
//	Với 1 inch = 2.54 cm và 1 foot = 12 inches.
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the length to covert (cm): ");
	float a = in.nextFloat();
	float cmToFoot = 12f;
	float cmToInch = 2.54f;
	float aFoot = (float) a/cmToFoot;
	float aInch = (float) a/cmToInch;
	System.out.printf("%nConverted values: %.2f feet %.2f inch", aFoot, aInch);	
}
//==========================================================================================
public static void question19() {
	
}
}
