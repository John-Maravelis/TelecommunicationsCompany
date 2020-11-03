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
 * This servlet is responsible for handling the update process of an existing plan.</br>
 * @return status page, either login or admin homepage.
 * @author John Maravelis 
 */
@WebServlet("/AdminUpdatePlanServlet")
public class AdminUpdatePlanServlet extends HttpServlet {
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
			result = adminDao.updatePlan(plan_id, description, speechTime, sms, data, price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		//setting up the values  to be displayed on the status page
		if (result) {
			request.setAttribute("status", "Plan "+plan_id+" has been updated!");
			request.setAttribute("aTag","adminHomepage.jsp");
			request.setAttribute("aTagText", "Go to homepage.");
		}
		else {
			request.setAttribute("status", "There was a problem, please try again.");
			request.setAttribute("aTag","admin-updatePlan.jsp");
			request.setAttribute("aTagText", "Go back.");
		}
		
		String targetPage = "admin-updatePlanStatus.jsp";
		requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request, response);
	}
}
