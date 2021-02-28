package com.vti.backend;

import java.util.Arrays;
import java.util.Collections;

import com.vti.entity.Department;

public class assignment3Ex5 {
public static void main(String[] args) {
	
}
public void question55() {
//	Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
//	không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
	
	Department department1 = new Department("Accounting");

	Department department2 = new Department("accounting");

	if (department1.equals(department2)) {
		System.out.println("Equal!");
	} else {
		System.out.println("Not equal!");
	}
}
//==========================================================================================
public void question567() {
//	Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//	sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//	VD:
//	Accounting
//	Boss of director
//	Marketing
//	Sale
//	Waiting room

	//	input
	Department department1 = new Department("Accounting");
	
	Department department2 = new Department("Sale");
	
	Department department3 = new Department("Marketing");
	
	Department department4 = new Department("Waiting room");
	
	Department department5 = new Department("Boss of director");

	//	put Department objects into arrays
	Department[] departments = {department1, department2, department3, department4, department5};
	
	//	sort function
	Collections.sort(Arrays.asList(departments));
	
	//	printout after sorted
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
}