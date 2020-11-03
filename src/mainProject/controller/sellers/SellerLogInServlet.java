package mainProject.controller.sellers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainProject.dao.SellerDAO;
import mainProject.model.Seller;
import mainProject.passwordEncryption.*;

/**
 * This servlet is responsible for handling the seller login.</br>
 * The servlet create a hash value with the given username's salt in the DB</br>
 * so as to compare it with the stored hash value of the given username's password.</br> 
 * @return status page, either login page or seller homepage.
 * @author John Maravelis 
 */
@WebServlet("/SellerLogInServlet")
public class SellerLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Encryption encryption = new Encryption();
		SellerDAO sellerDao = new SellerDAO();
		RequestDispatcher requestDispatcher = null;
		
		String username = request.getParameter("username");
//		  password hashing attempt code  
//		  try { 
//			  String password = encryption.generateHash(request.getParameter("password"), clientDao.getSalt(username);
//		  } catch (SQLException ex) { ex.printStackTrace(); }
		
		//generate encryption for the password submitted
		String password = encryption.generateHash(request.getParameter("password"));
		Seller seller = new Seller(username, password);
		boolean result = false;
		
		try {
			result = sellerDao.sellerAuthentication(seller);
		} catch (SQLException e) {
			System.out.println(e);
		}
		//setting up the values for the status page
		if (result) {
			String userType = "seller";
			//creating a session and setting the attributes to be saved
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userType", userType);
			
			request.setAttribute("status", "You have successfully logged in!");
			request.setAttribute("aTag","sellerHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", " A problem has occured.");
			request.setAttribute("aTag","sellerLogIn.html");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "seller-logInStatus.jsp";
		
		requestDispatcher =request.getRequestDispatcher(targetPage);		
		requestDispatcher.forward(request,response);
	}
}
