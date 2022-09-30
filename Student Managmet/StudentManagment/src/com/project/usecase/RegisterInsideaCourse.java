package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.inpliment.StudentPerfome;

public class RegisterInsideaCourse {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter roll no...");
		int roll=sc.nextInt();
		System.out.println("Enter course id");
		int cid=sc.nextInt();
		
		StudentPerfome sp=new StudentPerfome();
		try {
			sp.registerInsideaCourse(roll, cid);
		} catch (StudentExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
