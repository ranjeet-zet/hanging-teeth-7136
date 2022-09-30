package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.inpliment.StudentPerfome;

public class DeleteCourse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course name");
		String cname = sc.next();
		StudentPerfome sp = new StudentPerfome();
		try {
			String msg = sp.deleteCourse(cname);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
