package com.project.been;

import com.project.inpliment.StudentPerfome;

public class Student {
	private String name;
	private int marks;
	private String email;
	private String pass;
	private int roll;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int marks, String email, String pass, int roll) {
		super();
		this.name = name;
		this.marks = marks;
		this.email = email;
		this.pass = pass;
		this.roll = roll;
	}
	
	

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", email=" + email + ", pass=" + pass + ", roll=" + roll
				+ "]";
	}

}
