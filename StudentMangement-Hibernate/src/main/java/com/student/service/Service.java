package com.student.service;

import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentImp;
import com.student.entity.Student;

public class Service {
		public void service() {
			Student t=null;
			
			Scanner sc= new Scanner(System.in);
			StudentImp st = new StudentImp();
			boolean result=true;
			while(result) {
				System.out.println("1.Insert \n2.Update \n3.Delete \n4.View All the data \n5.Read Data by RollNo \n6.get total no.of Student \n7.Find maximum and minimum percentage\n8.Exited");
				System.out.println("enter the choice");
				int ch=sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("enter the data \nId:\nName:\nage:\naddress:\nPercentage");
				t=new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.next(),sc.next());
				st.insert(t);
				System.out.println("Data inserted");
				break;

			case 2:
				System.out.println("enter the data either you want to save or update \nId:\nName:\nage:\naddress:\nPercentage");
				t=new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next());
				st.update(t);
				System.out.println("Data Updated ");
				break;

			case 3:
				System.out.println("enter the rollno to delete");
				Student student2 = new Student();
				Student student = student2;
				t=student;
				t.setRollNo(sc.nextInt());
				st.delete(t);
				System.out.println("Data deleted");
				break;
				
			case 4:
			
				List<Student> list = st.viewAll();
				for(Student stlist:list) {
					System.out.println(stlist);
					
				}
				break;
			
			
			case 5:
				System.out.println("Enter the rollno");
				t=new Student();
				Student stud= st.view(sc.nextInt());
				System.out.println(stud.toString());
				
				break;
				
			case 6:
				List studentCount = st.studentCount();
				System.out.println(studentCount);
			break;
			
			case 7:
				List<Object[]> per = st.max_min_Percentage();
				for(Object[] stu:per) {
					System.out.println("Minimum Percentage -"+stu[0]);
					System.out.println("Maximum Percentage -"+stu[1]);

					
				}
				
			break;
			
			case 8:
				result=false;
				System.out.println("Exited");
			break;

			default:
				System.out.println("-------Invalid choice-------");
				result=false;
				break;
			}
			
			
					
			
			}
			
		}

}
