package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Dao.OfferDAO;
import Dao.loginDAO;
import Model.Customer;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private loginDAO  login;
  
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			login = new loginDAO();

		} catch (Exception e) {
			throw new ServletException(e);
	
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer c = new Customer ();
		c = login.getCustomerInfo(email);
		
			if (c == null) 
			{
				request.setAttribute("loginResult", "false");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response); 
              
               }
				
                else if (c.getEmail_address().equals(email) && c.getPassword().equals(password)) 
			{
                	
                	
                	
                	request.setAttribute("loginResult", "true");
    				//request.setAttribute("Customer", c);
    				
    				HttpSession session = request.getSession(true);
    				session.setAttribute("Customer", c);
    				
    				RequestDispatcher rd = request.getRequestDispatcher("/HomeController");
                    rd.forward(request, response); 
                	
                    
                	
			}
				
			
			else 
			{
				request.setAttribute("loginResult", "false");
				RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response); 
				
			}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
	}

}
