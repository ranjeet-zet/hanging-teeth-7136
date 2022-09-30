package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.been.Course;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class AddNewCourse {
	public static void add() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details of course which you want to add");
		System.out.println("Enter course name : ");
		String cname=sc.next();
		System.out.println("Enter fee of course : ");
		int fee=sc.nextInt();
		StudentPerfome sp=new StudentPerfome();
		try {
			String s= sp.addCoures(cname, fee);
			System.out.println(s);
		} catch (CourseException e) {
		System.out.println("Course add fail...");
			
		}
		
	}
	
}