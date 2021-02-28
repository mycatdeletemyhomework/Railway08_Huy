package com.vti.backend;

import java.util.Scanner;

public class StringProcessing {
//==========================================================================================
public static String stringRefinement(String s) {
	//	remove the spaces at the beginning and the end of the string
	s = s.trim();
			
	//	remove multiple spacing - for more information check trim() regex
	s = s.trim().replaceAll(" +", " ");
		
	return s;
}
//==========================================================================================
public void nameProcessing() {
//	input: full name (with random spacing at the beginning and the end, first letter not capitalized)
//	output: first name, middle name, surname (separated, first letter capitalized)
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter user full name here: ");
	String s = scanner.nextLine();
	
	//	first, we need to refine the input
	s = stringRefinement(s);
	
	//	then split the refined string to individual words (array)
	String[] split = s.split(" ");
	
	//	upper case first letters of each letters
	for (int i = 0; i < split.length; i++) {
		split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
	}
	
	//	the first string of split array is first name
	System.out.println("\nFirst name: " + split[0]);
	
	//	the full name contains only 2 words, there is no middle name
	if (split.length <= 2) {
		System.out.print("This person doesn't have middle name!");
	} else {
		System.out.print("Middle name: ");
		for (int i = 1; i < split.length - 1; i++) {
			System.out.print(split[i] + " ");
		}
	}
	
	//	the last string of split array is family name
	System.out.println("Family name: " + split[split.length -1]);
}
//==========================================================================================
public void isReversedString() {
//	check if 2 strings is the reversed form of each other
//	input: ("word" "drow") / ("word" "drod")
//	output: Yes / No
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter first string here: ");
	String s1 = scanner.nextLine();
	System.out.print("Please enter second string here: ");
	String s2 = scanner.nextLine();
	
	//	create a boolean to store the result
	boolean isReversed = true;
	
	//	if only 2 strings are in a same length, then continue process
	if (s1.length() == s2.length()) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(s2.length()-i-1)) {
				isReversed = false;
				break;
			}
		}
	} else {
		//	if 2 strings are not in a same length, result = false
		isReversed = false;
	}
	
	//	print out the result
	if (isReversed == true) {
		System.out.println("Yes");
	} else {
		System.out.println("No");
	}
}
//==========================================================================================
}
