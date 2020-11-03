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
 * This servlet is responible for presenting the current bill of the client.</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/ClientShowBillServlet")
public class ClientShowBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDAO clientDao = new ClientDAO();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(); 
		String[] bill = new String[5];
		
		String username = (String) session.getAttribute("Cusername");
		
		try {
			clientDao.clientBill(username, bill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on clientBill.jsp
		if(bill != null) {
			request.setAttribute("phoneNumber", bill[1]);
			request.setAttribute("bill_id", bill[2]);
			request.setAttribute("month", bill[3]);
			request.setAttribute("plan", bill[4]);
			request.setAttribute("price", bill[5]);
		}
		
		String targetPage = "client-bill.jsp";
		
		requestDispatcher =request.getRequestDispatcher(targetPage);		
		requestDispatcher.forward(request,response);
	}
}
