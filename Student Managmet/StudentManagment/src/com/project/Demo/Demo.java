package com.project.Demo;

import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Course;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class Demo {

	public static void main(String[] args){

		StudentPerfome sp = new StudentPerfome();

		try {
			Course pri = sp.searchCourse("javascript");

			System.out.println(pri);

		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
