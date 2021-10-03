package servlets.event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.event.Event;
import service.category.CategoryService;
import service.event.EventServiceImpl;

/**
 * Servlet implementation class EventDetailsSrv
 */
@WebServlet("/eventDetails")
public class EventDetailsSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int event_id = Integer.parseInt(request.getParameter("id"));
			
			Event event = EventServiceImpl.getEventByID(event_id);
			
			request.setAttribute("event", event);
			// request.setAttribute("category", CategoryService.getCategoryByID(event.getCategoryId()));
			
			request.getRequestDispatcher("/jsp/event/eventDetails.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
