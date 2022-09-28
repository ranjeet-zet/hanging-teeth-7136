package com.project.inpliment;

import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Student;

public interface StudentInterface {
	
	public String registerStudent(String name,int marks,String email,String passwrod); 
	public Student getStudentByRollNo(int roll)throws StudentExcption;
	public Student loginStudent(String email,String pass) throws StudentExcption;
	public String registerInsideaCourse(int roll,int courseid) throws StudentExcption,CourseException;
	public String addCoures(String name,int fee)throws CourseException;
	
	
}
