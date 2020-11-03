package mainProject.controller.sellers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainProject.dao.SellerDAO;

/**
 * This servlet is responible for allocating a plan to a client.</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/SellerPlanToClientServlet")
public class SellerPlanToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellerDAO sellerDao = new SellerDAO();
		RequestDispatcher requestDispatcher = null;
		String phoneNumber = request.getParameter("clientPhoneNumber");
		String planID = request.getParameter("planID");
		boolean result = false;
		
		try {
			result = sellerDao.planToClient(phoneNumber, planID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "Plan was successfully allocated!");
			request.setAttribute("aTag","sellerHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", "There was a problem, please try again.");
			request.setAttribute("aTag","seller-planToClient.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "seller-planToClientStatus.jsp";
		
		requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request,response);
	}
}
