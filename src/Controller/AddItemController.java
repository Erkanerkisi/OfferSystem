package Controller;

import java.io.IOException;
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
import Model.Customer;
import Model.Item;
import Model.OfferItems;

/**
 * Servlet implementation class AddItemController
 */
@WebServlet("/AddItemController")
public class AddItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OfferItems oi;
	private ItemDAO it;
	List<OfferItems> offeritems = new ArrayList<>();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		

		try {
			it = new ItemDAO();
			oi = new OfferItems();

		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(true);
		Customer c = (Customer) session.getAttribute("Customer");

		// Listeleri olustur
		
		
		
			
			oi.setItem_id(Integer.parseInt( request.getParameter("items")));
			oi.setQuantity(Integer.parseInt( request.getParameter("qty")));
			
			loadDropDownLists(request, response);
			request.getParameter("viewItems");
			offeritems.add(oi);
		
		
		   request.setAttribute("viewItems", offeritems);
		   
		   RequestDispatcher dispacher = request.getRequestDispatcher("/add_Offer_Form.jsp");
		   dispacher.forward(request, response);
		
	}

	public void loadDropDownLists(HttpServletRequest request, HttpServletResponse response) {

		List<Item> items;
		try {
			items = it.getListItems();

			request.setAttribute("ALLITEMS", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
