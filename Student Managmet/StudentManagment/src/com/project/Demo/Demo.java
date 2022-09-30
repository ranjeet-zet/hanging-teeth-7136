package com.project.Demo;

import java.util.List;

import com.project.Excaption.BatchException;
import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Course;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class Demo {

	public static void main(String[] args) {

		StudentPerfome sp = new StudentPerfome();

		
		try {
			List<Student> s= sp.viewStudentInEveryBatch("fw19");
			s.forEach((ss)->{
				System.out.println(ss);
			});
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
