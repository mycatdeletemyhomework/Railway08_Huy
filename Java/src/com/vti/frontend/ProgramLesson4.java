package com.vti.frontend;

import com.vti.entity.*;

public class ProgramLesson4 {
	public static void main(String[] args) {
		ProgramLesson4 program = new ProgramLesson4();
		program.l4e4q1Exercution();
	}
	
public void l4e4q1Exercution() {
	String s1 = "";
	String s2 = "";

	// create student using constructor
	Student student1 = new Student("Bui Quang Huy", "Hanoi");
	// set GPA
	student1.setGpa(7.0f);
	// extra GPA
	student1.extraGpa(3.0f);
	// check 3
	s1 = student1.toString();
	System.out.println(s1);
	s2 = student1.getData();
	System.out.println(s2);
}
}
