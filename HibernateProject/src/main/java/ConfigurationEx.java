import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigurationEx {
	
	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Mobile.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session openSession = sessionFactory.openSession();
		
		
		
		
		
		Mobile mobile = openSession.load(Mobile.class,6);
		//System.out.println(mobile);
		openSession.beginTransaction().commit();
		
		
		Mobile mobile2 = new Mobile(7,"vivo",25000);
		openSession.save(mobile2);
		
		
		
		
		
	}

}
