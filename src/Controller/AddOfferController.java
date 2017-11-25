package Controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ItemDAO;
import Dao.OfferDAO;
import Dao.OfferLinesDAO;
import Dao.dropDownLists;
import Model.Customer;
import Model.DropDownList;
import Model.Item;
import Model.Offer;
import Model.OfferItems;
import Model.OfferLines;

/**
 * Servlet implementation class AddOfferController
 */
@WebServlet("/AddOfferController")
public class AddOfferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OfferDAO od;

	private ItemDAO it;

	private OfferItems oi;

	private OfferLinesDAO ol;

	List<OfferItems> offeritems = new ArrayList<>();

	public AddOfferController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {
			od = new OfferDAO();
			it = new ItemDAO();
			ol = new OfferLinesDAO();

		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Customer c = (Customer) session.getAttribute("Customer");

		if (request.getParameter("Status") != null) {

			// New
			if (request.getParameter("Status").equals("NEW")) {
				offeritems = new ArrayList<>();

				request.setAttribute("viewItems", offeritems);

			}

			// Create

			// Add Item
			if (request.getParameter("Status").equals("ADD")) {

				oi = new OfferItems();
				try {
					oi = it.getItemInfoById(Integer.parseInt(request.getParameter("items")));
					oi.setQuantity(Integer.parseInt(request.getParameter("qty")));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				offeritems.add(oi);
				request.setAttribute("viewItems", offeritems);

			}
			
			if (request.getParameter("Status").equals("Delete")) {

					int v_index = Integer.parseInt(request.getParameter("indexofarray"));
				offeritems.remove(v_index);
				request.setAttribute("viewItems", offeritems);

			}

			if (request.getParameter("Status").equals("create")) {

				try {
					// Validations
				
					
				 
		
					createoffer(request, response,c);
					
					 
					//createofferlines(request, response, offeritems, c);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		try {
			loadDropDownLists(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispacher = request.getRequestDispatcher("/add_Offer_Form.jsp");
		dispacher.forward(request, response);

	}

	public void loadDropDownLists(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<DropDownList> ddl = dropDownLists.getDropDownListElementsByType("OFFERTYPE");
		request.setAttribute("OFFERTYPES", ddl);

		List<Item> items;
		try {
			items = it.getListItems();

			request.setAttribute("ALLITEMS", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createoffer(HttpServletRequest request, HttpServletResponse response,Customer c) throws Exception {

		int i = 1;
		List <OfferLines> temp = new ArrayList<>();
		String offerType = request.getParameter("offertype");
		String offerNumber = request.getParameter("offernumber");
		String offerDate =  request.getParameter("offerdate");
		int customerID =c.getCustomerId();
		Double totalAmount = Double.parseDouble(request.getParameter("totalamount"));

		//Date OfferDate =  new SimpleDateFormat("dd.MM.yyyy").parse(offerDate);
		java.util.Date OfferDate = new SimpleDateFormat("dd.MM.yyyy").parse(offerDate);
		
		Offer offer = new Offer(offerNumber, offerType, new java.sql.Date(OfferDate.getTime()), customerID,
				totalAmount);
		
		for (OfferItems xx : offeritems) {

			OfferLines offerlines = new OfferLines();
			offerlines.setCustomer_id(c.getCustomerId());
			offerlines.setItem_id(xx.getItem_id());
			offerlines.setQuantity(xx.getQuantity());
			offerlines.setLine_number(i);
			temp.add(offerlines);
			i++;

		}
		
		
		

		od.InsertOffer(offer,temp);
		request.setAttribute("customerid", customerID);

	}

	public void createofferlines(HttpServletRequest request, HttpServletResponse response, List<OfferItems> offeritems,
			Customer c) throws Exception {
		int i = 1;

		for (OfferItems xx : offeritems) {

			OfferLines offerlines = new OfferLines();
			offerlines.setCustomer_id(c.getCustomerId());
			offerlines.setItem_id(xx.getItem_id());
			offerlines.setQuantity(xx.getQuantity());
			offerlines.setLine_number(i);

			ol.InsertOfferLines(offerlines);
			i++;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
