package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Constructor;
import Model.Project;
import _JSP.HibernateUtil;

public class ConstructorDao {

	public ConstructorDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
public static Constructor getConstructorById(int Id) {
		
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
	SessionFactory sf =HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		//List <OfferType> ol  = session.createCriteria(OfferType.class).list();
		
		
		
		Constructor con =session.get(Constructor.class, Id);
		
		session.close();
		
		return con;
				
		
	}
	

	
	
	
	
	

}
