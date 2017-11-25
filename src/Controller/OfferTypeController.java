package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.OfferType;
import Dao.OfferTypeDao;


@WebServlet("/OfferTypeController")
public class OfferTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
    public OfferTypeController() {
        super();

    
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		//Add
		
		
		if (request.getParameter("Operation").equals("add")) {
		String name =  request.getParameter("name");
		String type =  request.getParameter("offertype");	
		
		
		
		
		OfferTypeDao.insert(new OfferType(name,type));
		
		}
		
		// List 
		List<OfferType> ListOfferTypes =OfferTypeDao.getListofOfferTypes();
		
		request.setAttribute("ListOfferTypes", ListOfferTypes);

		RequestDispatcher dispacher = request.getRequestDispatcher("/DefineOfferType.jsp");
		dispacher.forward(request, response);
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
