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
 * This servlet is responible for allocating a new bill to a client</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/SellerBillToClientServlet")
public class SellerBillToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SellerDAO sellerDao = new SellerDAO();
		RequestDispatcher requestDispatcher = null;
		
		int clientID = Integer.parseInt(request.getParameter("clientID"));
		int billID = Integer.parseInt(request.getParameter("billID"));
		int planID = Integer.parseInt(request.getParameter("planID"));
		String month = request.getParameter("month");
		String status = request.getParameter("status");
		double price = Double.parseDouble(request.getParameter("price"));
		boolean result = false;

		try {
			result = sellerDao.createBill(billID, status, month, price, planID, clientID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "Bill has been successfully created!");
			request.setAttribute("aTag","sellerHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", " A problem has occured.");
			request.setAttribute("aTag","seller-createBill.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "seller-createBillStatus.jsp";
		
		requestDispatcher =request.getRequestDispatcher(targetPage);		
		requestDispatcher.forward(request,response);

		
	}
}
