package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OfferDAO;
import Model.Customer;
import Model.Offer;

@WebServlet("/HomeController")
public class ApprovedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OfferDAO od;

	public ApprovedController() {
		super();

	}

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Customer c = (Customer) session.getAttribute("Customer");

		

		List<Offer> offers;
		try {
			offers = od.getApprovedOffers(c.getCustomerId());
			request.setAttribute("APPROVED_OFFER_LISTS", offers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println("ADDED= " + offers.get(2));

		

		RequestDispatcher dispacher = request.getRequestDispatcher("/approvedDocuments.jsp");
		dispacher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}



}
