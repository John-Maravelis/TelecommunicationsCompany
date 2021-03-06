package mainProject.controller.clients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This servlet is responsible for handling the client logout process.</br>
 * The servlet remove the saved attributes from the session and then invalidates it.</br>
 * @author John Maravelis.
 */
@WebServlet("/ClientLogOutServlet")
public class ClientLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("userType");
		session.invalidate();
		response.sendRedirect("index.html");
	}
}
