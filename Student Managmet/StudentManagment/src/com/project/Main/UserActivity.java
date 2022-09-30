package com.project.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.usecase.AddNewCourse;
import com.project.usecase.AllocateStudentUnderBatch;
import com.project.usecase.CreateBatch;
import com.project.usecase.DeleteCourse;
import com.project.usecase.GetAllCourse;
import com.project.usecase.RegisterStudent;
import com.project.usecase.SearchCourse;
import com.project.usecase.UpdateFeeByCourse;
import com.project.usecase.UpdateStudent;
import com.project.usecase.UpdateTotalSeatinBatch;
import com.project.usecase.ViewStudentInEveryBatch;

public class UserActivity {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserActivity us = new UserActivity();

		System.out.println();
		System.out.println("Choose an options - \n" + "1. Admin Login\n" + "2. Student Login\n");

		System.out.println();
		System.out.println("Enter any number from above: ");

		int choice = 0;
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");
			main(args);

		}

		switch (choice) {
		case 1:
			System.out.println("Enter admin username");
			String username = sc.next();
			System.out.println("Enter admin password");
			String password = sc.next();
			if (username.equals("root") && password.equals("root")) {
				System.out.println("Admin login successful");
				UserActivity.admin();
			} else {
				System.out.println("Username or password are wrong try again");
				main(args);
			}
			break;
		case 2:
			UserActivity.student();
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
//			UserActivity.selectUser();
		}
	}

	public static void student() {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"	1. Register himself in a course with a username and password (email should be the username)\r\n"
						+ "	2. can update this details.\r\n"
						+ "	3. can see all the available course list and their seat availability.\r\n"
						+ " 	4. Go back");

		System.out.println();
		System.out.println("Enter any number from above which you want to operate");
		int c = 0;

		try {
			c = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			UserActivity.student();
		}

		switch (c) {
		case 1:
			RegisterStudent rs = new RegisterStudent();
			rs.main(null);
			break;
		case 2:
			UpdateStudent ss = new UpdateStudent();
			ss.main(null);
			break;
		case 3:
			GetAllCourse.get();
			break;
		case 4:
			main(null);
			break;
		}
		UserActivity.student();

	}

	public static void admin() {
		Scanner sc = new Scanner(System.in);

		System.out.println("	 1. Add a new Courses\r\n" + "         2. Update Fees of course.\r\n"
				+ "         3. Delete a course from any Training session.\r\n"
				+ "         4. Search information about a course.\r\n" + "         5. Create Batch under a course.\r\n"
				+ "         6. Allocate students in a Batch under a course.\r\n"
				+ "         7. Update total seats of a batch.\r\n" + "         8. View the students of every batch.\r\n"
				+ "         9. Go Back");

		System.out.println();
		System.out.println("Enter any number from above which you want to operate");

		int c = 0;

		try {
			c = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input!");
			System.out.println("Try again....");
			UserActivity.admin();
		}

		switch (c) {
		case 1:
			AddNewCourse.add();
			break;
		case 2:
			UpdateFeeByCourse.main(null);
			break;
		case 3:
			DeleteCourse.main(null);
			break;
		case 4:
			SearchCourse.main(null);
			break;
		case 5:
			CreateBatch.main(null);
			break;
		case 6:
			AllocateStudentUnderBatch.main(null);
			break;
		case 7:
			UpdateTotalSeatinBatch.main(null);
			break;
		case 8:
			ViewStudentInEveryBatch.main(null);
			break;
		case 9:
			main(null);
		}

		UserActivity.admin();

	}

}
