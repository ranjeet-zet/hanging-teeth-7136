package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.StudentExcption;
import com.project.inpliment.StudentPerfome;

public class UpdateStudent {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Roll no");
		int roll=scanner.nextInt();
		StudentPerfome sp=new StudentPerfome();
		try {
			String ss= sp.updateStudent(roll);
			System.out.println(ss);
		} catch (StudentExcption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
