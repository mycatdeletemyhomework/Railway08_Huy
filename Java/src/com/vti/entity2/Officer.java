package com.vti.entity2;

public class Officer extends Employee {
	private String job;
	
	public Officer(String fullName, String job) {
		super(fullName);
		this.job = job;
		System.out.println("Adding officer...");
	}
}
