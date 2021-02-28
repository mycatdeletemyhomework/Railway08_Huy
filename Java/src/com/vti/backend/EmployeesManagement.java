package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity2.*;

public class EmployeesManagement {
	Scanner in = new Scanner(System.in);
//==========================================================================================
public List<Employee> sampleData() {
	System.out.println("Adding sample employees data...");
	List<Employee> employees = new ArrayList<Employee>();
	employees.add(new Employee("Employee 1 - Normal empployee"));
	employees.add(new Engineer("Employee 2 - Engineer", "Aerospace"));
	employees.add(new Officer("Employee 3 - Officer", "Front of house"));
	employees.add(new Worker("Employee 4 - Worker", (byte) 3));
	System.out.println("====== Done adding sample data ======");
	return employees;
}
//==========================================================================================
public void addEmployee(List<Employee> employees) {
	System.out.println("Please enter new employee full name: ");
	String s = in.nextLine();
	employees.add(new Employee(s));
}
//==========================================================================================
public List<Employee> nameSearch(String s, List<Employee> employees) {
	System.out.println("Exercuting name search tool...");
	
	// create initial values
	int match = 0;
	List<Employee> matchedEmployee = new ArrayList<Employee>();
	
	// search logic
	for (Employee employee : employees) {
		String fullName = employee.getName();
		if (fullName.contains(s)) {
			matchedEmployee.add(employee);
			match += 1;
		}
	}
	
	// print number of matches and return the matches
	System.out.printf("There is %d match(es)!", match);
	return matchedEmployee;
}
//==========================================================================================
public void displayData(List<Employee> employees) {
	for (Employee employee : employees) {
		System.out.println(employee.getName());
	}
}
//==========================================================================================
public List<Employee> deleteEmployee(String s, List<Employee> employees) {
	System.out.println("Exercuting name deleting tool...");
	
	// execute name search for matches
	EmployeesManagement search = new EmployeesManagement();
	List<Employee> matchedEmployees = search.nameSearch(s, employees);
	
	employees.removeAll(matchedEmployees);
	
	System.out.printf("After delete, there are %d employee(s) left!", employees.size());
	return employees;
}
//==========================================================================================
public void quitProgram() {
	System.out.println("Quitting...");
	return;
}
//==========================================================================================
}
