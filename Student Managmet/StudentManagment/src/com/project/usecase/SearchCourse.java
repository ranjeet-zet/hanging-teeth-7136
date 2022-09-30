package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.been.Course;
import com.project.inpliment.StudentPerfome;

public class SearchCourse {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Course Name");
		String s=sc.next();
		StudentPerfome sp=new StudentPerfome();
		try {
			Course c= sp.searchCourse(s);
			System.out.println(c);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
