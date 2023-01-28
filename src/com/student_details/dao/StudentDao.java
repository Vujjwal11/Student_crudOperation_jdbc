package com.student_details.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student_details.dto.Student;

//	Insert Student
public class StudentDao {
	public void insertStudent(Student std) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_student";
			String username = "root";
			String pasword = "ajjubhai";

			con = DriverManager.getConnection(url, username, pasword);

			Statement s = con.createStatement();
			String i = "insert into student values(" + std.getSid() + ",'" + std.getSname() + "','" + std.getScourse()
					+ "','" + std.getSbranch() + "','" + std.getSemail() + "','" + std.getSaddress() + "',"
					+ std.getSmob() + "," + std.getSfee() + ")";
			s.execute(i);
			System.out.println("insert successfully");

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	Details of Student
	public int getById(int id) {
		Connection con = null;
		int id1 = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_student";
			String username = "root";
			String password = "ajjubhai";

			con = DriverManager.getConnection(url, username, password);

			Statement s = con.createStatement();
			String select = "select * from student where sid = " + id + "";
			ResultSet res = s.executeQuery(select);

			while (res.next()) {
				id1 = res.getInt("sid");
				System.out.println("Details of Student are : ");
				System.out.println("-----------------------------------");
				System.out.println("sid = " + id1);
				System.out.println("sname = " + res.getString("sname"));
				System.out.println("scourse = " + res.getString("scourse"));
				System.out.println("sbranch = " + res.getString("sbranch"));
				System.out.println("semail = " + res.getString("semail"));
				System.out.println("saddress = " + res.getString("saddress"));
				System.out.println("smob = " + res.getLong("smob"));
				System.out.println("sfee = " + res.getInt("sfee"));
				System.out.println("-----------------------------------");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return id1;
	}

//	Delete the Student
	public void delete(int id) {
		Connection con1 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_student";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String delete = "delete from student where sid = " + id + "";
			s1.executeUpdate(delete);
			System.out.println("Delete Successfully");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	Update the student details
	public void updateStudent(Student std) {
	
		Connection con1 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_student";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String update = "update Student set sname='" + std.getSname() + "',scourse='" + std.getScourse()
					+ "',sbranch='" + std.getSbranch() + "',semail='" + std.getSemail() + "',saddress='"
					+ std.getSaddress() + "',smob=" + std.getSmob() + ",sfee=" + std.getSfee() + " where sid = "+std.getSid()+" ";
			int id1 = s1.executeUpdate(update);
			if(id1!=0) {
				System.out.println("Update Successfully");
			} else {
				System.out.println("Id Not Found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	Dispaly the Student details
	public List<Student> displayStudent(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_student";
			String username = "root";
			String pasword = "ajjubhai";

			con = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con.createStatement();
			String display = "select * from student";
			ResultSet res = s1.executeQuery(display);
			
			List<Student> l = new ArrayList<Student>();
			
			while(res.next()) {
				int id = res.getInt("sid");
				String s = res.getString("sname");
				String s2 = res.getString("scourse");
				String s3 = res.getString("sbranch");
				String s4 = res.getString("semail");
				String s5 = res.getString("saddress");
				long v = res.getLong("smob");
				int t = res.getInt("sfee");
				
				Student std = new Student();
				std.setSid(id);
				std.setSname(s);
				std.setScourse(s2);
				std.setSbranch(s3);
				std.setSemail(s4);
				std.setSaddress(s5);
				std.setSmob(v);
				std.setSfee(t);	
				
				l.add(std);
			}
			return l;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	
	
	
	
	
}
