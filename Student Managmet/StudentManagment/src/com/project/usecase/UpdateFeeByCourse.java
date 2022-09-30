package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.inpliment.StudentPerfome;

public class UpdateFeeByCourse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course Name");
		String cname = sc.next();
		System.out.println("Enter course new Fee");
		int fee = sc.nextInt();
		StudentPerfome sp = new StudentPerfome();
		try {
			String ss = sp.updateCourseFee(cname, fee);
			System.out.println(ss);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
