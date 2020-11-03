package mainProject.controller.clients;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainProject.dao.ClientDAO;

/**
 * This servlet is responible for handling the payment proccess of a client's bill.</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/ClientPayBillServlet")
public class ClientPayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDAO clientDao = new ClientDAO();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession();
		boolean result = false;
		String status = "paid";
		String username = (String) session.getAttribute("Cusername");
		
		try {
			result = clientDao.payBill(status, username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "Bill has been paid-off!");
			request.setAttribute("aTag","clientHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", " A problem has occured.");
			request.setAttribute("aTag","client-bill.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "client-billStatus.jsp";

		requestDispatcher =request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request,response);
		
	}
}
