package testing_system;

import java.util.Date;

public class Exam {
	short id;
	String code;
	String title;
	CategoryQuestion category_id;
	byte duration;
	Account creator;
	Date createDate;
	Question[] questions;
}
