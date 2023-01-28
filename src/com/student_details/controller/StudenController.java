package com.student_details.controller;

import java.util.List;
import java.util.Scanner;

import com.student_details.dto.Student;
import com.student_details.service.StudentService;

public class StudenController {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();
		Student std = new Student();
		
		while(true) {
			System.out.println("1.Insert\n2.GetById\n3.Delete\n4.Update\n5.Display\n6.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the Id : ");
				int a = sc.nextInt();
				std.setSid(a);
				System.out.println("Enter the Name");
				String d = sc.next();
				d+=sc.nextLine();
				std.setSname(d);
				System.out.println("Enter the Course");
				String f = sc.next();
				f+=sc.nextLine();
				std.setScourse(f);
				System.out.println("Enter the Branch ");
				String g = sc.next();
				
				std.setSbranch(g);
				System.out.println("Enter the Email");
				String h = sc.next();
				std.setSemail(h);
				System.out.println("Enter the Address");
				String i = sc.next();
				i+=sc.nextLine();
				std.setSaddress(i);
				System.out.println("Enter the Mobile Number");
				long l = sc.nextLong();
				std.setSmob(l);
				System.out.println("Enter the Fee");
				int q = sc.nextInt();
				std.setSfee(q);
				service.insertStudent(std);
				
			}break;
			case 2:{
				System.out.println("Enter the Id");
				int id = sc.nextInt();
				service.getById(id);
			}break;
			case 3: {
				System.out.println("Enter the Id");
				int m = sc.nextInt();
				service.delete(m);
			}break;
			case 4: {
				System.out.println("Enter the Id For Update Details");
				int r = sc.nextInt();
				std.setSid(r);
				
				System.out.println("1.Update sname\n2.Update scourse\n3.Update sbranch\n4.Update semail\n5.Update saddress\n6.Update smob\n7.Update sfee");
				int t = sc.nextInt();
				switch(t) {
				case 1: {
					System.out.println("Enter the name for update");
					String l = sc.next();
					l+=sc.nextLine();
					std.setSname(l);
					
				}break;
				case 2: {
					System.out.println("Enter the course for update");
					String k = sc.next();
					k+=sc.nextLine();
					std.setScourse(k);
					
				}break;
				case 3: {
					System.out.println("Enter the branch for update");
					String j = sc.next();
					std.setSbranch(j);
					
				}break;
				case 4: {
					System.out.println("Enter the email for update");
					String j = sc.next();
					std.setSemail(j);
					
				}break;
				case 5: {
					System.out.println("Enter the address for update");
					String p = sc.next();
					p+=sc.nextLine();
					std.setSaddress(p);
					
				}break;
				case 6: {
					System.out.println("Enter the mobile number for update");
					long o = sc.nextLong();
					std.setSmob(o);
					
				}break;
				case 7: {
					System.out.println("Enter the fee for update");
					int fee = sc.nextInt();
					std.setSfee(fee);
					
				}break;
				
				}
				service.updateStudent(std);
			}break;
			case 5:{
				List<Student> list = service.displayStudent();
				
				for (Student std1 : list) {
					System.out.println("-----------------------------------");
					System.out.println();
					System.out.println("sid = "+std1.getSid());
					System.out.println("sname = "+std1.getSname());
					System.out.println("scourse = "+std1.getScourse());
					System.out.println("sbranch = "+std1.getSbranch());
					System.out.println("semail = "+std1.getSemail());
					System.out.println("saddress = "+std1.getSaddress());
					System.out.println("smob = "+std1.getSmob());
					System.out.println("sfee = "+std1.getSfee());
					System.out.println();
					System.out.println("-----------------------------------");
					System.out.println("===================================");
				}
				
			}break;
			case 6: {
				
			}break;
			}
		}
				
	}

}
