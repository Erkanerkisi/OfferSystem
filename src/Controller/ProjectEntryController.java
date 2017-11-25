package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Constructor;
import Model.OfferType;
import Model.Project;
import Dao.ConstructorDao;
import Dao.OfferTypeDao;
import Dao.ProjectDao;


@WebServlet("/ProjectEntryController")
public class ProjectEntryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
    public ProjectEntryController() {
        super();

    
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//Add
		
		
		if (request.getParameter("Operation").equals("add")) {
		String ProjectNumber =  request.getParameter("ProjectNumber");
		String ProjectName =  request.getParameter("ProjectName");	
		int ConsId = Integer.parseInt( request.getParameter("ConsName"));	
		
		
		Constructor con = ConstructorDao.getConstructorById(ConsId);
		
		Project p = new Project(ProjectNumber,ProjectName);
		p.setConstructor(con);
		
		ProjectDao.insert(p);
		
		}
		
		// List 
		
		List<Constructor> ListOfCons  = ProjectDao.LoadConsDropDown();
		
		
		List<Project> ListOfProjects =ProjectDao.getListofProjects();
		
		request.setAttribute("ListOfProjects", ListOfProjects);
		request.setAttribute("ListOfCons", ListOfCons);

		RequestDispatcher dispacher = request.getRequestDispatcher("/DefineProject.jsp");
		dispacher.forward(request, response);
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
