package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.backend.EmployeesManagement;
import com.vti.entity2.Employee;

public class ProgramLesson5 {
//==========================================================================================
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	// add sample data
	EmployeesManagement data = new EmployeesManagement();
	List<Employee> employees = data.sampleData();
	
	// create a program pointer
	EmployeesManagement program = new EmployeesManagement();
	
	// program selection logic
	System.out.println("Do you want to?: 1-Add employee / 2-Search / 3-Display data / 4-Delete");
	System.out.println("Or press any other key to exit program: ");
	int selection = in.nextInt();
	switch (selection) {
	case 1: {
		program.addEmployee(employees);
		break;
	}
	case 2: {
		System.out.print("You choose to search! Please enter name here: ");
		in.nextLine(); // just to consume excess line 
		String s = in.nextLine();
		program.nameSearch(s, employees);
		break;
	}
	case 3: {
		program.displayData(employees);
		break;
	}
	case 4: {
		System.out.println("You choose to delete! Please enter name here: ");
		in.nextLine();
		String s = in.nextLine();
		program.deleteEmployee(s, employees);
		break;
	}
	default:
		program.quitProgram();
	}
	
}
//==========================================================================================
}
