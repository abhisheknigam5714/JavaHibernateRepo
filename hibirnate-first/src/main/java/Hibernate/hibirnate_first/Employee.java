package Hibernate.hibirnate_first;

import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class Employee {
	
	public static void getConnection() {
		Configuration configuration = new Configuration();
		
		Properties properties = new Properties();
		
		properties.put(Environment.JNDI_URL, "jdbc:mysql://localhost:3306");
		properties.put(Environment.USER, "root");
	}

}
