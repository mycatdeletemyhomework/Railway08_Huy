package com.vti.entity;

import java.util.Date;

public class Question {
	private  short id;
	private String content;
	private 	CategoryQuestion category;
	private 	TypeQuestion type;
	private Account creator;
	private Date createDate;
	private Exam[] exams;
}
