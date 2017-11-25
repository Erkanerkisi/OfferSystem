package Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.OfferType;
import _JSP.HibernateUtil;

public class OfferTypeDao {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		//OfferType of = new OfferType ("ERKAN","OFFERTYPE");
//		
//		//insert(of);
//		
//		getListofOfferTypes();
//
//	}
	
	
	
	
	public static void insert(OfferType of) {
		
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sf =HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		try {
		session.beginTransaction();
		
	
		
		session.save(of);
		
		session.getTransaction().commit();
		}
		finally {
			
			session.close();
		}
		
		
		
	}
	
	
public static List<OfferType> getListofOfferTypes() {
		
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sf =HibernateUtil.getSessionFactory();	
	
		Session session = sf.openSession();
		
		
		//List <OfferType> ol  = session.createCriteria(OfferType.class).list();
		
		
		@SuppressWarnings("unchecked")
		List <OfferType> ol =session.createQuery("from OfferType order by 1 desc").list();	
		
		session.close();
		
		return ol;
				
		
	}
	
	
	

}
