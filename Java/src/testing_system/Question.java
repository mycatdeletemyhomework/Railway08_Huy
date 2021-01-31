package testing_system;

import java.util.Date;

public class Question {
	short id;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	Date createDate;
	Exam[] exams;
}
