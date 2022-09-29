package com.project.inpliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project.Excaption.CourseException;
import com.project.Excaption.StudentExcption;
import com.project.been.Batch;
import com.project.been.Course;
import com.project.been.Student;
import com.project.database.DBC;

public class StudentPerfome implements StudentInterface {

	@Override
	public String registerStudent(String name, int marks, String email, String passwrod) {
		email = email.toLowerCase();
		String ret = "Data Not Inserted";
		try (Connection conn = DBC.ProvideConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("insert into student(name,marks,email,password) values(?,?,?,?)");

			ps.setString(1, name);
			ps.setInt(2, marks);
			ps.setString(3, email);
			ps.setString(4, passwrod);

			int x = ps.executeUpdate();
			System.out.println(x);
			if (x > 0)
				ret = "Data Inserted Secussfully...";
		} catch (SQLException e) {
			// TODO: handle exception
			ret = e.getMessage();
		}

		return ret;
	}

	@Override
	public Student getStudentByRollNo(int roll) throws StudentExcption {

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where roll=?");

			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Student st = new Student();
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setMarks(rs.getInt("marks"));
				st.setRoll(rs.getInt("roll"));
				st.setPass("***********");
				return st;
			} else {
				throw new StudentExcption("Student Not Avilable with roll no :" + roll);
			}

		} catch (Exception e) {
			throw new StudentExcption(e.getMessage());
		}

	}

	@Override
	public Student loginStudent(String email, String pass) throws StudentExcption {

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where email=? AND password=?");

			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Student st = new Student();
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setMarks(rs.getInt("marks"));
				st.setRoll(rs.getInt("roll"));
				st.setPass("***********");

				return st;
			} else {
				throw new StudentExcption("Invalid Username or password..");
			}

		} catch (Exception e) {
			throw new StudentExcption(e.getMessage());
		}

	}

	@Override
	public String registerInsideaCourse(int roll, int courseid) throws StudentExcption, CourseException {
		String message = "Not Resgistered";

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement p2 = conn.prepareStatement("Select * frome course where cid=?");
				p2.setInt(1, courseid);

				ResultSet rs2 = p2.executeQuery();

				if (rs2.next()) {

					PreparedStatement ps3 = conn.prepareStatement("insert into course_student values(?,?)");

					ps3.setInt(1, courseid);
					ps3.setInt(2, roll);

					int x = ps3.executeUpdate();

					if (x > 0)
						message = "Student registered inside the Course Sucessfully.. ";
					else
						throw new StudentExcption("Techical error..");

				} else {
					throw new CourseException("Invalid Course...");
				}
			} else {
				throw new StudentExcption("Invalid Student...");
			}

		} catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String addCoures(String name, int fee) throws CourseException {
		String msg = "Course Inserting Fail...";

		name = name.toLowerCase();
		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement p = conn.prepareStatement("select * from course where cname=?");

			p.setString(1, name);
			ResultSet rs = p.executeQuery();

			if (rs.next()) {
				throw new CourseException("Course already registred...");
			} else {
				PreparedStatement ps = conn.prepareStatement("insert into course(cname,fee) values(?,?)");
				ps.setString(1, name);
				ps.setInt(2, fee);

				int x = ps.executeUpdate();
				if (x > 0) {
					msg = "Course add Successfully...";
				}
			}
		} catch (Exception e) {
			msg = e.getMessage();
		}

		return msg;
	}

	@Override
	public String updateCourseFee(String cname, int newFee) throws CourseException {
		cname = cname.toLowerCase();
		String ret = "Course fee updating fail...";

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from course where cname=?");
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("update course set fee=? where cname=?");
				ps2.setInt(1, newFee);
				ps2.setString(2, cname);
				int i = ps2.executeUpdate();
				if (i > 0) {
					ret = "Fee Update Succesfully...";
				} else {
					ret = "Fee Update Fail...";
				}

			} else {
				throw new CourseException("Please enter valid course...");
			}

		} catch (Exception e) {
			ret = e.getMessage();
		}

		return ret;
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
		cname = cname.toLowerCase();
		String ret = "Delete fail....";

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from course where cname=?");
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("delete from course where cname=?");
				ps2.setString(1, cname);
				int i = ps2.executeUpdate();
				if (i > 0) {
					ret = "Delete course Succesfully...";
				} else {
					ret = "Delete course Fail...";
				}

			} else {
				throw new CourseException("Please enter valid course...");
			}
		} catch (Exception e) {
			ret = e.getMessage();
		}
		return ret;
	}

	@Override
	public Course searchCourse(String cname) throws CourseException {
		cname = cname.toLowerCase();
		Course cc = null;

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from course where cname=?");
			ps.setString(1, cname);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("cid");
				int fee = rs.getInt("fee");
				String name = rs.getString("cname");
				cc = new Course(id, name, fee);
			} else {
				throw new CourseException("Enter valid course name...");
			}

		} catch (Exception e) {
			throw new CourseException(e.getMessage());
		}

		return cc;
	}

	@Override
	public String createBatch(Batch batch) throws CourseException {

		return null;
	}

	@Override
	public String allocateStudentUnderBatch(String sid, int bid) throws StudentExcption {

		return null;
	}

	@Override
	public String updateTotalSeatinBatch(String bname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> viewStudentInEveryBatch(String bname) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public String updateStudent(int roll) throws StudentExcption {
		String ret = "Update Student Secussfully...";

		try (Connection conn = DBC.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where roll=?");
			ps.setInt(1, roll);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				while (true) {
					Scanner sc = new Scanner(System.in);
					System.out.println("1 Update Name");
					System.out.println("2 Update Password");
					try {
						int i = sc.nextInt();
						if (i == 1) {
							System.out.println("Enter New Name");
							String newName = sc.next();
							PreparedStatement ps2 = conn.prepareStatement("update student set name=? where roll=?");
							ps2.setString(1, newName);
							ps2.setInt(2, roll);
							int a = ps2.executeUpdate();
							if (a > 0) {
								ret = "Update Succesfully...";
								break;
							} else {
								ret = "Update fail...";
								break;
							}
						} else if (i == 2) {
							System.out.println("Enter New Password");
							String newPass = sc.next();
							PreparedStatement ps3 = conn.prepareStatement("update student set password=? where roll=?");
							ps3.setString(1, newPass);
							ps3.setInt(2, roll);
							int b = ps3.executeUpdate();
							if (b > 0) {
								ret = "Update Succesfully...";
								break;
							} else {
								ret = "Update fail...";
								break;
							}
						} else {
							System.out.println("Enter valid input");
						}

					} catch (Exception e) {
						System.out.println("Enter valid input");
						continue;

					}
				}

			} else {
				throw new StudentExcption("Student not fount with roll :" + roll);
			}
		} catch (Exception e) {
			ret = e.getMessage();
		}
		return ret;
	}

}
