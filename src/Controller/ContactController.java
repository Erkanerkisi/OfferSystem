package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConstructorDao;
import Dao.ContactDao;
import Dao.ProjectDao;
import Model.Constructor;
import Model.Contact;
import Model.Project;

/**
 * Servlet implementation class ContactController
 */
@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int projectid = Integer.parseInt(request.getParameter("id"));
		
		
			
		
		
		if (request.getParameter("Operation").equals("add")) {
			String name =  request.getParameter("NameSurname");
			String email =  request.getParameter("Email");	
			String phone =  request.getParameter("Phone");
			
			
			Project p = ProjectDao.getProjectById (projectid);
			/*
			List <Contact> loc = new ArrayList<>();
			*/
			Contact cont = new Contact();
			/*
			cont.setName_surname(name);
			cont.setEmail(email);
			cont.setPhone(phone);
			cont.setProject_id(p);
			
			loc.add(cont);

			p.setContacts(loc);
			
			ProjectDao.insert(p);*/
			
			cont.setName_surname(name);
			cont.setEmail(email);
			cont.setPhone(phone);
			cont.setProject_id(p);
		    
			
		    ContactDao.Insert(cont);
			
			
			
			}
	
			
			
			
			List<Contact> ListOfContacts =ContactDao.getListofContacts(projectid);
			
			request.setAttribute("ListOfContacts", ListOfContacts);
			request.setAttribute("id", projectid);
			
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/ProjectContacts.jsp");
		dispacher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
