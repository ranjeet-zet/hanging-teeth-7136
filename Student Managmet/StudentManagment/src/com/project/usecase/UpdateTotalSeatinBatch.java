package com.project.usecase;

import java.util.Scanner;

import com.project.inpliment.StudentPerfome;

public class UpdateTotalSeatinBatch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter batch name");
		String bname=sc.next();
		System.out.println("Enter new Seat");
		int nseat=sc.nextInt();
		
		StudentPerfome sp=new StudentPerfome();
		String s= sp.updateTotalSeatinBatch(bname, nseat);
		System.out.println(s);

	}
}
