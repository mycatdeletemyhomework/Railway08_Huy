package assignment1;

public class Department implements Comparable<Department> {
	public short id;
	public String name;
	public Account[] members;
	
//==========================================================================================
//	this added prior to Lesson 3 - exercise 5 - question 5
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		//	datatype casting: Object obj > Department other
		Department other = (Department) obj;
		
		//	equal logic
		if (name.equalsIgnoreCase(other.name)) {
			return true;
		} 
			return false;
	}

//==========================================================================================
//	this added prior to Lesson 3 - exercise 5 - question 6
	@Override
	public int compareTo(Department other) {
		// other = department2
		if (other == null) {
			return -1;
		} else if (name.compareToIgnoreCase(other.name) < 0) {
			return -1;
		} else if (name.compareToIgnoreCase(other.name) > 0) {
			return 1;
		} 
			return 0;
	}

//==========================================================================================	
//	this added prior to Lesson 3 - exercise 5 - question 7
//	@SuppressWarnings("unused")
//	@Override
//	public int compareTo(Department other) {
//		
//		//	split name to choose the last word of the name
//		String[] nameSplit = name.split(" ");
//		String[] nameOtherSplit = other.name.split(" ");
//		
//		//	select last word of the name
//		String nameFinal = nameSplit[nameSplit.length - 1];
//		String nameOtherFinal = nameOtherSplit[nameOtherSplit.length - 1];
//		
//		//	compare logic
//		if (other == null) {
//			return -1;
//		} else if (nameFinal.compareToIgnoreCase(nameOtherFinal) < 0) {
//			return -1;
//		} else if (nameFinal.compareToIgnoreCase(nameOtherFinal) > 0) {
//			return 1;
//		} 
//			return 0;
//	}
	
//==========================================================================================
	@Override
	public String toString() {
		return "ID: " + id + " " + name;
	}
	
//==========================================================================================
//	this added prior to Lesson 4 - exercise 1 - question 1
//	Question 1:
//	Tạo constructor cho department:
	
//	a) không có parameters
	public Department() {
	}
	
//	b) Có 1 parameter là nameDepartment và default id của Department = 0;
	 public Department(String name) {
		this.id = 0;
		this.name = name;
	}
//	make constructor public remove the error that "the constructor is not visible"
}