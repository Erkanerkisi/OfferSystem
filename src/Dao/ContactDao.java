package Dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import Model.Contact;
import Model.Project;
import _JSP.HibernateUtil;

public class ContactDao {

	public ContactDao() {
		// TODO Auto-generated constructor stub
	}
	
	
public static void Insert(Contact c)  {
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
	SessionFactory sf =HibernateUtil.getSessionFactory();	
	
	Session session = sf.openSession();
	
	try {	
		session.beginTransaction();
		

		//Constructor con = session.get(Constructor.class, consid);
		//p.setConstructor(con);
		
		
		session.save(c);
		
		session.getTransaction().commit();
				
	}
	finally {
		
		session.close();
		System.out.println("Contact Session Closed!!!!");

	}
		
		
		
	}
	
	
	
public static List<Contact> getListofContacts(int id) {
		
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		SessionFactory sf =HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
	
		
		//List <OfferType> ol  = session.createCriteria(OfferType.class).list();
		
		
		
		//List <Contact> ol =session.createCriteria(Contact.class).list();
	
		
		List <Contact> ol = session.createCriteria(Contact.class).createAlias("project", "p").add(Restrictions.eq("p.project_id", id)).list();

		
	
			session.close();
	
		
		return ol;	
				
		
	}

}
