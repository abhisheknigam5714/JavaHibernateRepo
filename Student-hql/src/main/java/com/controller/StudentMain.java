package com.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Student;

public class StudentMain {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
//		String hql="from Student_test";
//		Query<Student> query = session.createQuery(hql,Student.class);
//		List<Student> list = query.list();
//		for (Student student : list) {
//			System.out.println(student);
//			
//			
			
		
		String hql="update Student s  s.name=:name where s.id=:id ";
		session.createQuery(hql);
		}

	}

}
