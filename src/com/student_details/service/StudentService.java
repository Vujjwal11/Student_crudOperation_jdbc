package com.student_details.service;

import java.util.List;

import com.student_details.dao.StudentDao;
import com.student_details.dto.Student;

public class StudentService {
	StudentDao dao = new StudentDao();
	
//	Insert student
	public void insertStudent(Student std) {
		dao.insertStudent(std);
	}
	
//	Details of Student
	public int getById(int id) {
//		return dao.getById(id);
		int id2 = dao.getById(id);
		if(id2==id) {
			
		}
		else {
			System.out.println("Id Not Found");
		}
		return id2;
	}
	
//	Delete the Student
	public void delete(int id) {
		int q = dao.getById(id);
		if(q==id) {
			dao.delete(id);
		}
		else {
			System.out.println("Id Not Found");
		}
	}
	
//	Update student details
	public void updateStudent(Student std) {
	dao.updateStudent(std);
	
	}
	
//	display student
	public List<Student> displayStudent(){
		return dao.displayStudent();
	}
	
	
	
	
	
}

