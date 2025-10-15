package com.student.dao;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.entity.Student;

public class ConfigurationFactory {
	
	public static SessionFactory conneection() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Student.class);
		
		config.configure();
		
		SessionFactory sesfac = config.buildSessionFactory();
		
		
		
		return sesfac;
	}
	

}
