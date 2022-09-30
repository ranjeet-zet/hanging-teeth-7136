package com.project.usecase;

import java.util.List;
import java.util.Scanner;

import com.project.Excaption.BatchException;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class ViewStudentInEveryBatch {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter batch name");
		String bname=sc.next();
		StudentPerfome sp=new StudentPerfome();
		try {
			List<Student> s= sp.viewStudentInEveryBatch(bname);
			s.forEach((ss)->{
				System.out.println(ss);
			});
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
