package _JSP;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static SessionFactory sessionFactory;
		
	
	public static SessionFactory getSessionFactory()
	{
	    
		
		if (sessionFactory==null) {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		}
		
		else {
			
			return sessionFactory;
			
		}
		
		
	} 
	
	

	public HibernateUtil() {
		
	}

}
