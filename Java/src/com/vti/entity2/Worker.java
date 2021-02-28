package com.vti.entity2;

public class Worker extends Employee {
	private byte level;
	
	public Worker(String fullName, byte level) {
		super(fullName);
		this.level = level;
		System.out.println("Adding worker...");
	}


}
