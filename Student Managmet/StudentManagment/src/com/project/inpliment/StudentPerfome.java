package com.project.inpliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project.Excaption.BatchException;
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
	public String createBatch(String bname, int seat, String coursename) throws CourseException {
		coursename = coursename.toLowerCase();
		bname = bname.toLowerCase();
		String ret = "Batch Create fail...";

		try (Connection conn = DBC.ProvideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from batch where bname=?");
			ps.setString(1, bname);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ret = "Batch name already exit...";
			} else {

				PreparedStatement ps1 = conn.prepareStatement("select * from course where cname=?");
				ps1.setString(1, coursename);

				ResultSet rs1 = ps1.executeQuery();
				if (rs1.next()) {
					PreparedStatement ps2 = conn.prepareStatement("insert into batch(bname,seat) values(?,?)");
					ps2.setString(1, bname);
					ps2.setInt(2, seat);
					int x = ps2.executeUpdate();

					if (x > 0) {
						ret = "Batch add succesfully...";

						PreparedStatement ps3 = conn.prepareStatement("select * from batch where bname=?");
						ps3.setString(1, bname);

						ResultSet rs2 = ps3.executeQuery();
						if (rs2.next()) {
							PreparedStatement ps4 = conn
									.prepareStatement("insert into course_batch(bid,cname) values(?,?)");
							ps4.setInt(1, rs2.getInt("bid"));
							ps4.setString(2, coursename);
							int y = ps4.executeUpdate();

						} else {
							ret = "Some error...";
						}

					} else {
						ret = "Batch add fail...";
					}
				} else {
					ret = "Enter a valid course name...";
				}
			}

		} catch (Exception e) {
			ret = e.getMessage();
		}

		return ret;
	}

	@Override
	public String allocateStudentUnderBatch(int roll, int bid, int cid) throws StudentExcption {
		String ret = "Alloting fail...";
		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select * from student where roll=?");
			ps1.setInt(1, roll);

			ResultSet rs = ps1.executeQuery();
			if (rs.next()) {

				PreparedStatement ps2 = conn.prepareStatement("select * from batch where bid=?");
				ps2.setInt(1, bid);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {

					PreparedStatement ps3 = conn.prepareStatement("select * from course where cid=?");
					ps3.setInt(1, cid);
					ResultSet rs3 = ps3.executeQuery();
					if (rs3.next()) {

						PreparedStatement ps4 = conn.prepareStatement("insert into course_batch_student values(?,?,?)");
						ps4.setInt(1, bid);
						ps4.setInt(2, roll);
						ps4.setInt(3, cid);

						int xx = ps4.executeUpdate();
						if (xx > 0) {
							ret = "Allocate succesfully...";
						} else {
							ret = "Alocate fail...";
						}

					} else {
						ret = "Course id not valid...";
					}
				} else {
					ret = "Batch id not valid...";
				}
			} else {
				ret = "Student roll no not valid...";
			}
		} catch (Exception e) {
			throw new StudentExcption(e.getMessage());
		}

		return ret;
	}

	@Override
	public String updateTotalSeatinBatch(String bname, int newSeat) {
		bname = bname.toLowerCase();
		String ret = "Update fail...";

		try (Connection conn = DBC.ProvideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from batch where bname=?");
			ps.setString(1, bname);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("update batch set seat=? where bname=?");
				ps2.setInt(1, newSeat);
				ps2.setString(2, bname);
				int x = ps2.executeUpdate();
				if (x > 0) {
					ret = "Update Succesfully...";
				} else {
					ret = "Update Fail...";
				}

			} else {
				ret = "Enter valid Batch name...";
			}

		} catch (Exception e) {
			ret=e.getMessage();
		}

		return ret;
	}

	@Override
	public List<Student> viewStudentInEveryBatch(String bname)throws BatchException {
		List<Student> students=new ArrayList<>();
		
		try (Connection conn = DBC.ProvideConnection()) {
			
			PreparedStatement ps1=conn.prepareStatement("select * from batch where bname=?");
			ps1.setString(1, bname);
			
			ResultSet rs=ps1.executeQuery();
			if(rs.next()) {

				PreparedStatement ps=conn.prepareStatement("select * from student where roll=(select roll from course_batch_student where bid=(select bid from batch where bname=?)) group by name");
				ps.setString(1, bname);
				ResultSet rs1=ps.executeQuery();
				while (rs1.next()) {
					Student s=new Student();
					s.setEmail(rs1.getString("email"));
					s.setMarks(rs1.getInt("marks"));
					s.setName(rs1.getString("name"));
					s.setRoll(rs1.getInt("roll"));
					s.setPass(rs1.getString("password"));
					
					students.add(s);
					
				}		
			}else {
				throw new BatchException("Batch name not Valid...");
			}		
		} catch (Exception e) {
			throw new BatchException(e.getMessage());
		}
	
		return students;
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

	@Override
	public List<Course> getAllCourse() throws CourseException {
		List<Course> courses = new ArrayList<>();
		
		
		try  (Connection conn = DBC.ProvideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from course");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int ci=rs.getInt("cid");
				String cn=rs.getString("cname");
				int f=rs.getInt("fee");
				Course cc=new Course(ci, cn, f);
				courses.add(cc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			new BatchException("No course found");
		}
		return courses;
	}

}
