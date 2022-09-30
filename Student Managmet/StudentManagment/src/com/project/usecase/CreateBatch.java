package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.inpliment.StudentPerfome;

public class CreateBatch {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Batch Name");
		String bname=sc.next();
		System.out.println("Enter total seat");
		int seat=sc.nextInt();
		System.out.println("Enter the Course Name");
		String cname=sc.next();
		
		StudentPerfome sp=new StudentPerfome();
		try {
			String msg= sp.createBatch(bname, seat, cname);
			System.out.println(msg);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
