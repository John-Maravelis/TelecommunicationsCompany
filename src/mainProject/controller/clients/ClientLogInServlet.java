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
import mainProject.model.Client;
import mainProject.passwordEncryption.*;

/**
 * This servlet is responsible for handling the client login.</br>
 * The servlet create a hash value with the given username's salt in the DB</br>
 * so as to compare it with the stored hash value of the given username's password.</br> 
 * @return status page, either login or client homepage.
 * @author John Maravelis 
 */
@WebServlet("/ClientLogInServlet")
public class ClientLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Encryption encryption = new Encryption();
		ClientDAO clientDao = new ClientDAO();
		RequestDispatcher requestDispatcher = null;
		
		String username = request.getParameter("username");
//		  password hashing attempt code  
//		  try { 
//			  String password = encryption.generateHash(request.getParameter("password"), clientDao.getSalt(username);
//		  } catch (SQLException ex) { ex.printStackTrace(); }
		 
		//generate encryption for the password submitted
		String password = encryption.generateHash(request.getParameter("password"));
		Client client = new Client(username, password);
		boolean result = false;
		
		try {
			result = clientDao.clientAuthentication(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values for the status page
		if (result) {
			String userType = "client";
			//creating a session and setting the attributes to be saved
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userType", userType);
			
			request.setAttribute("status", "You have successfully logged in!");
			request.setAttribute("aTag","clientHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", " A problem has occured.");
			request.setAttribute("aTag","clientLogIn.html");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "client-logInStatus.jsp";

		requestDispatcher =request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request,response);
	}
}
