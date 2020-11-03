package mainProject.controller.admins;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainProject.dao.AdminDAO;
import mainProject.model.Seller;
import mainProject.passwordEncryption.Encryption;


/**
 * This servlet is responible for creating a new seller.</br>
 * The servlet gets the values from the admin and then passes them to AdminDAO </br>
 * so as to hanlde the sign up process. </br>
 * In the case of the password, the servlet calls the create salt method to create a byte[] of a random number </br>
 * then converts that to a String and then passes the salt string and the given password to generateHash in </br>
 * order to create a hashed password that will be stored in the DB.</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/AdminNewSellerServlet")
public class AdminNewSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		AdminDAO adminDao = new AdminDAO();
		Encryption encryption = new Encryption();
		RequestDispatcher requestDispatcher = null;
		
		String sellerID = request.getParameter("sellerID");
		String username = request.getParameter("username");
		//attempt at creating satled password
		// String salt = encryption.createSalt();
		//String password = encryption.generateHash(request.getParameter("password"), salt);
		
		//passing the input password to generateHash so as to create a hashed password
		String password = encryption.generateHash(request.getParameter("password"));
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String adminUsername = request.getParameter("adminUsername");

		//to save the salt just add salt as a parameter, make sure a salt column exists in the DB
		//and add in SellerDAO.newClient the PreparedStatement for the salt
		Seller seller = new Seller(sellerID, username, password, firstName, surname, adminUsername);
		boolean result = false;
		
		try {
			result = adminDao.newSeller(seller);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "New seller has been successfully registered!");
			request.setAttribute("aTag","adminHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", "There was a problem, please try again.");
			request.setAttribute("aTag","admin-newSeller.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "admin-newSellerStatus.jsp";
		
		requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request,response);
	}
}
