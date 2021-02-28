package com.vti.entity2;

public class Employee {
	private String fullName;
	private short age;
	private Gender gender;
	private String address;
	
	public Employee(String fullName) {
		this.fullName = fullName;
		System.out.println("Adding employee...");
	}
	
	public String getName() {
		return this.fullName;
	}
}
