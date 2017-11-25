package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Constructor;
import Model.OfferType;
import Model.Project;
import _JSP.HibernateUtil;

public class ProjectDao {

	public ProjectDao() {
		// TODO Auto-generated constructor stub
	}
	
	
/*

	public static void main(String[] args) {
		

		int id = 1;
				
		Project p = new Project ("Proje3","TRIA Projesi");
		
		insert(p);

	}
	
	*/
	
	public static void insert(Project p) {
		
		SessionFactory sf =HibernateUtil.getSessionFactory();
				
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		
		
		Session session = sf.openSession();
		try {
		session.beginTransaction();
		
		
		
		//Constructor con = session.get(Constructor.class, consid);
		//p.setConstructor(con);
		
		
		//session.save(p);
		//session.persist(p);
		
		session.saveOrUpdate(p);
		
		session.getTransaction().commit();
		
		
		}
		finally {
			
			session.close();
			System.out.println("Project Session Closed!!!!");
		}
		
		
		
		
	}
	
public static List<Project> getListofProjects() {
		
		
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	    SessionFactory sf =HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		
		//List <OfferType> ol  = session.createCriteria(OfferType.class).list();
		
		
		
		List <Project> ol =session.createQuery("from Project order by 1 desc").list();	
		
		session.close();
		
		return ol;
				
		
	}


public static Project getProjectById(int id) {
	
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	Session session = sf.openSession();
	
	
	//List <OfferType> ol  = session.createCriteria(OfferType.class).list();
	
	
	
	Project p =session.get(Project.class,id);
	
	session.close();
	
	return p;
			
	
}
	
		public static List<Constructor> LoadConsDropDown() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		
		List <Constructor> listofcons = new ArrayList<Constructor>();
		listofcons = session.createQuery("from Constructor order by name asc").list();
		
		
		
		
		
		session.close();
		
		return listofcons;
		
		
	}

}
