package com.project.Demo;

import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Course;
import com.project.been.Student;
import com.project.inpliment.StudentPerfome;

public class Demo {

	public static void main(String[] args){

		StudentPerfome sp = new StudentPerfome();

		String pri = sp.updateTotalSeatinBatch("fw19",45);

		System.out.println(pri);

	}

}
