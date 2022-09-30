package com.project.usecase;

import java.util.Scanner;

import com.project.inpliment.StudentPerfome;

public class RegisterStudent {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name");
		String name = sc.next();
		System.out.println("Enter your Marks");
		int marks = sc.nextInt();
		System.out.println("Enter your Email");
		String email = sc.next();
		System.out.println("Enter your password");
		String pass = sc.next();
		StudentPerfome sp = new StudentPerfome();
		String msg = sp.registerStudent(name, marks, email, pass);
		System.out.println(msg);
	}

}
