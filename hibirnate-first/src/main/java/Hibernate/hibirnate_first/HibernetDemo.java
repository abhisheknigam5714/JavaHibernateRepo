package Hibernate.hibirnate_first;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetDemo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session openSession = sessionFactory.openSession();
		
		System.out.println(openSession);
		
	}

}
