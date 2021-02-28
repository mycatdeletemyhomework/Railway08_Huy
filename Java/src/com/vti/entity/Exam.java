package com.vti.entity;

import java.util.Date;

public class Exam {
	private short id;
	private 	String code;
	private String title;
	private CategoryQuestion category_id;
	private byte duration;
	private Account creator;
	private Date createDate;
	private Question[] questions;
}
