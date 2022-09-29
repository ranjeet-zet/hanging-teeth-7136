package com.project.inpliment;

import java.util.List;

import com.project.Excaption.BatchException;
import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Batch;
import com.project.been.Course;
import com.project.been.Student;

public interface StudentInterface {
	//Student......................
	public String registerStudent(String name,int marks,String email,String passwrod); 
	public Student getStudentByRollNo(int roll)throws StudentExcption;
	public Student loginStudent(String email,String pass) throws StudentExcption;
	public String registerInsideaCourse(int roll,int courseid) throws StudentExcption,CourseException;
	public String updateStudent(int roll)throws StudentExcption;
	
	//Admin....
	public String addCoures(String name,int fee)throws CourseException;
	public String updateCourseFee(String cname,int newFee)throws CourseException;
	public String deleteCourse(String cname)throws CourseException;
	public Course searchCourse(String cname)throws CourseException;
	public String createBatch(Batch batch)throws CourseException,BatchException;
	public String allocateStudentUnderBatch(String sid,int bid)throws StudentExcption;
	public String updateTotalSeatinBatch(String bname)throws BatchException;
	public List<Student> viewStudentInEveryBatch(String bname)throws BatchException;
	
	
	//public String updateFeeByCid(int cid,int fee)throws CourseException;
	
	
	
	
	
	
}
