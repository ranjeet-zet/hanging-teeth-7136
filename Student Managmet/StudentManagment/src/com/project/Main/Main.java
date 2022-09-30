package com.project.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// This is the main file
		// Applications starts from here...

		System.out.println("------------------------------------");
		System.out.println("Automated Student Registration System");
		System.out.println("------------------------------------");
		
		UserActivity us=new UserActivity();
		us.main(null);
	}
}
