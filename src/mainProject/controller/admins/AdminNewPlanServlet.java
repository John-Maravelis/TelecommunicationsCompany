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

/**
 * This servlet is responsible for creating a new plan.</br>
 * @return The status of the procedure, either failed or successful.
 * @author John Maravelis
 */
@WebServlet("/AdminNewPlanServlet")
public class AdminNewPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO adminDao = new AdminDAO();
		RequestDispatcher requestDispatcher = null;
		
		String plan_id = request.getParameter("PlanID");
		String description = request.getParameter("Description");
		int speechTime = Integer.parseInt(request.getParameter("SpeechTime"));
		int sms = Integer.parseInt(request.getParameter("Sms"));
		int data = Integer.parseInt(request.getParameter("Data"));
		double price = Double.parseDouble(request.getParameter("Price"));
		boolean result = false;
		
		try {
			result = adminDao.newPlan(plan_id, description, speechTime, sms, data, price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//setting up the values to be displayed on the status page
		if (result) {
			request.setAttribute("status", "New plan "+plan_id+" has been saved!");
			request.setAttribute("aTag","adminHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", "There was a problem, please try again.");
			request.setAttribute("aTag", "admin-newPlanStatus.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "admin-updatePlanStatus.jsp";
		requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request, response);
	}
}
