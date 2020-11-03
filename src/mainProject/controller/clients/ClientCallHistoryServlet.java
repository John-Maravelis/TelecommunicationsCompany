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
 * This servlet is responible for presenting the call history of the current client.</br>
 * @return values to be displayed in client-callHistory.
 * @author John Maravelis
 */
@WebServlet("/ClientCallHistoryServlet")
public class ClientCallHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDAO clientDao = new ClientDAO();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(); 
		
		String[] callHistory = new String[3];
		String username = (String) session.getAttribute("Cusername");
		
		try {
			clientDao.clientBill(username, callHistory);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on client-callHistory.jsp
		if(callHistory != null) {
			request.setAttribute("clientID", callHistory[1]);
			request.setAttribute("duration", callHistory[2]);
			request.setAttribute("caller", callHistory[3]);
		}
		
		String targetPage = "client-callHistory.jsp";
		
		requestDispatcher =request.getRequestDispatcher(targetPage);		
		requestDispatcher.forward(request,response);
	}
}
