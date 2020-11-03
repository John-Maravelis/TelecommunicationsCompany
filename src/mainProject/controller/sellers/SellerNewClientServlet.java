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
import mainProject.model.Client;
import mainProject.passwordEncryption.Encryption;


/**
 * This servlet is responible for creating a new client.</br>
 * The servlet gets the values from the seller and then passes them to SellerDAO </br>
 * so as to hanlde the sign up process. </br>
 * In the case of the password, the servlet calls the create salt method to create a byte[] of a random number </br>
 * then converts that to a String and then passes the salt string and the given password to generateHash in </br>
 * order to create a hashed password that will be stored in the DB.</br>
 * @return status page, either failed or successful
 * @author John Maravelis
 */
@WebServlet("/SellerNewClientServlet")
public class SellerNewClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		SellerDAO sellerDao = new SellerDAO();
		Encryption encryption = new Encryption();
		RequestDispatcher requestDispatcher = null;

		String clientID = request.getParameter("clientID");
		String username = request.getParameter("username");
		//attempt at creating satled password
		// String salt = encryption.createSalt();
		//String password = encryption.generateHash(request.getParameter("password"), salt);
		
		//passing the input password to generateHash so as to create a hashed password
		String password = encryption.generateHash(request.getParameter("password"));
		String firstName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		String afm = request.getParameter("AFM");
		String zip = request.getParameter("zip");
		String sellerUsername = request.getParameter("sellerUsername");
		
		//to save the salt just add salt as a parameter, make sure a salt column exists in the DB
		//and add in AdminDAO.newSeller the PreparedStatement for the salt
		Client client = new Client(clientID, username, password, firstName, surname, phoneNumber, afm, zip, sellerUsername);
		boolean result = false;
		
		try {
			result = sellerDao.newClient(client);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "New client has been successfully registered!");
			request.setAttribute("aTag","sellerHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", "There was a problem, please try again.");
			request.setAttribute("aTag","seller-newClient.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "seller-newClientStatus.jsp";
		
		requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request,response);
	}
}
