package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.StudentExcption;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class GetStudentByRollNo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Roll no...");
		int roll=sc.nextInt();
		StudentPerfome sp=new StudentPerfome();
		try {
			Student ss= sp.getStudentByRollNo(roll);
			System.out.println(ss);
		} catch (StudentExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
