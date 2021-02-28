package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private float gpa;
//==========================================================================================	
	// constructor
	public Student(String name, String homeTown) {
		this.name = name;
		this.homeTown = homeTown;
		this.gpa = 0f;
	}
//==========================================================================================
	// getter / setter
	public void setGpa(float gpa) {
		if (0 <= gpa && 10 >= gpa) {
			this.gpa = gpa;
		} else {
			System.out.println("GPA is invalid");
			return;
		}
	}
	
	public void extraGpa(float extraGpa) {
		if (0 <= (this.gpa + extraGpa) && 10 >= (this.gpa + extraGpa)) {
			this.gpa += extraGpa;
		} else {
			System.out.println("Extra GPA is invalid");
			return;
		}
	}
	
	public String getData() {
		String graded = "";
		if (this.gpa < 4) {
			graded = "Weak";
		} else if (this.gpa >= 4  && this.gpa < 6) {
			graded = "Pass";
		} else if (this.gpa >= 6 && this.gpa < 8) {
			graded = "Good";
		} else {
			graded = "Excellent";
		}
		 
		return this.name + " " + this.gpa + " - Graded: " + graded + " ";
	}
//==========================================================================================
	// toString to check
	@Override
	public String toString() {
		return (this.id == 0 ? "ID is null - " : (this.id + " ")) + this.name + " " + this.gpa;
	}
}
