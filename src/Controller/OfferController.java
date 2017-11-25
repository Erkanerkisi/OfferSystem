package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Dao.OfferDAO;
import Model.Customer;
import Model.Offer;
import sun.rmi.server.Dispatcher;



@WebServlet("/OfferController")
public class OfferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OfferDAO  od;
	
	
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			od = new OfferDAO();

		} catch (Exception e) {
			throw new ServletException(e);
	
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//List the students
		
		try {
			
				String theCommand = request.getParameter("command");
				//System.out.println("theCommand= " + theCommand);
				
				if (theCommand ==null) { theCommand = "LIST"; }
				
				switch (theCommand) {
				
				case "LIST":
					listOffers(request,response);
					break;
				case "ADD":
					
					   addOffer(request,response);
					break;
					
				case "LOAD":
					  loadOffer(request,response);
						break;
				case "UPDATE":
					  updateOffer(request,response);
						break;
						
					default:
						listOffers(request,response);
						break;
				}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
		
		
	}


	
	
	private void updateOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("offerid= " + request.getParameter("offerid"));
		int offerId = Integer.parseInt(request.getParameter("offerid"));
		
		String offerNumber = request.getParameter("offernumber");
		String offerType = request.getParameter("offertype");
		String offerDate =  request.getParameter("offerdate");
		int customerID =   Integer.parseInt(request.getParameter("customerid"));
		Double totalAmount =  Double.parseDouble(request.getParameter("totalamount"));
	// New offer object
		Date OfferDate = new SimpleDateFormat("dd.MM.yyyy").parse(offerDate);
		
		
		Offer offer = new Offer (offerId,offerNumber,offerType,new java.sql.Date(OfferDate.getTime()),customerID,totalAmount);
		
		od.UpdateOffer(offer);
		request.setAttribute("customerid",customerID );
		
		listOffers(request,response);
	}


	private void loadOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int offerId = Integer.parseInt(request.getParameter("offerid"));
		String theCommand = request.getParameter("command");
		
		Offer o =od.getOffer(offerId);
		
		request.setAttribute("THE_OFFER", o);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/update_Offer_Form.jsp");
		dispacher.forward(request, response);
		
	}


	private void addOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
			// Get Parameter
				String offerNumber = request.getParameter("offernumber");
				String offerType = request.getParameter("offertype");
				String offerDate =  request.getParameter("offerdate");
				int customerID =   Integer.parseInt(request.getParameter("customerid"));
				Double totalAmount =  Double.parseDouble(request.getParameter("totalamount"));
			// New offer object
				Date OfferDate = new SimpleDateFormat("dd.MM.yyyy").parse(offerDate);

				
			//	java.sql.Date setofferDate = (java.sql.Date) new Date(format.parse(offerDate).getTime());

					Offer offer = new Offer (offerNumber,offerType,new java.sql.Date(OfferDate.getTime()),customerID,totalAmount);
			// DB insert
					od.InsertOffer(offer);
					
						
			// Back to list offers
					listOffers(request,response);
		
	}


	private void listOffers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//Get Students from OFFERDAO
		//Customer c = (Customer) request.getAttribute("Customer");
		
		HttpSession session = request.getSession(true);
		Customer c = (Customer) session.getAttribute("Customer");
		
		
		int a=1;
		
		List<Offer> offers  = od.getListOffers(c.getCustomerId());
		
		//System.out.println("ADDED= " + offers.get(2));
		
		request.setAttribute("OFFER_LISTS", offers);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/Documents.jsp");
		dispacher.forward(request, response);
		
		
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
