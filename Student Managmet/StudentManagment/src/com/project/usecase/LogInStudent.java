package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.StudentExcption;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class LogInStudent {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user email");
		String email=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		StudentPerfome sp=new StudentPerfome();
		try {
			Student ss= sp.loginStudent(email, pass);
		} catch (StudentExcption e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
