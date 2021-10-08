package servlets.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.category.Category;
import model.event.Event;
import service.category.CategoryService;
import service.event.EventServiceImpl;

/**
 * Servlet implementation class AddEventSrv
 */
@WebServlet("/add-event")
public class AddEventSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Category> categories = CategoryService.getCategories();
		
		request.setAttribute("categories", categories);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/event/add-event.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int eventManagerId = (int)(session.getAttribute("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			int availableTickets = Integer.parseInt(request.getParameter("available_tickets"));
			int status = Integer.parseInt(request.getParameter("status"));
			int onlineEvent = Integer.parseInt(request.getParameter("online_event"));
			int categoryId = Integer.parseInt(request.getParameter("category_id"));
			String venue = request.getParameter("venue");
			
			Event event = new Event(name, description, date, time, availableTickets, eventManagerId, status, onlineEvent, categoryId, venue);
			EventServiceImpl.addEvent(event);
			
			response.sendRedirect("/dashboard");
		}
	}

}
