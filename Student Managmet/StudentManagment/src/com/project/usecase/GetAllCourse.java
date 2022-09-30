package com.project.usecase;

import java.util.List;

import com.project.Excaption.CourseException;
import com.project.been.Course;
import com.project.inpliment.StudentPerfome;

public class GetAllCourse {
	
	public static void get() {
		StudentPerfome sp=new StudentPerfome();
		try {
			List<Course> courses = sp.getAllCourse();
			courses.forEach(c->{
				
				System.out.println("--------------------------");
				System.out.println("Course details - ");
				System.out.println("--------------------------");
				System.out.println("Course id - "+c.getCid());
				System.out.println("Course name - "+c.getCname());
				System.out.println("Course fee - "+c.getFee());
			});
		} catch (CourseException e) {
			e.printStackTrace();
		}
	}
}
