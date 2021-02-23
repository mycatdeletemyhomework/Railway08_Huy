package assignment1;

public class Department implements Comparable<Department> {
	public short id;
	public String name;
	public Account[] members;

//	this added prior to Lesson 3 - exercise 5 - question 6
//	@Override
//	public int compareTo(Department other) {
//		// other = department2
//		if (other == null) {
//			return -1;
//		} else if (other.name.charAt(0) > name.charAt(0)) { // so sanh theo ASCII
//			return -1;
//		} else if (other.name.charAt(0) < name.charAt(0)) { // so sanh theo ASCII
//			return 1;
//		} 
//			return 0;
//	}

//	this added prior to Lesson 3 - exercise 5 - question 7
	@SuppressWarnings("unused")
	@Override
	public int compareTo(Department other) {
		// other = department2
		String name1 = name.toLowerCase(); //do so sánh theo kiểu ASCII nên upper case and lower case matter!
		String othername1 = other.name.toLowerCase();
		
		String[] nameSplit = name1.split(" ");
		String[] nameOtherSplit = othername1.split(" ");
		
		if (other == null) {
			return -1;
		} else if (nameOtherSplit[nameOtherSplit.length - 1].charAt(0) > nameSplit[nameSplit.length - 1].charAt(0)) { // so sanh theo ASCII
			return -1;
		} else if (nameOtherSplit[nameOtherSplit.length - 1].charAt(0) < nameSplit[nameSplit.length - 1].charAt(0)) { // so sanh theo ASCII
			return 1;
		} 
			return 0;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + " " + name;
	}
}