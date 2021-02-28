package com.vti.entity2;

public class Engineer extends Employee {
	private String major;
	
	public Engineer(String fullName, String major) {
		super(fullName);
		this.major = major;
		System.out.println("Adding engineer...");
	}
}
