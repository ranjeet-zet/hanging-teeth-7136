package com.project.usecase;

import java.util.Scanner;

import com.project.Excaption.StudentExcption;
import com.project.inpliment.StudentPerfome;

public class AllocateStudentUnderBatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student roll no");
		int roll=sc.nextInt();
		System.out.println("Enter Batch id");
		int bid=sc.nextInt();
		System.out.println("Enter Course id");
		int cid=sc.nextInt();
		StudentPerfome sp=new StudentPerfome();
		try {
			String s= sp.allocateStudentUnderBatch(roll, bid, cid);
			System.out.println(s);
		} catch (StudentExcption e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
