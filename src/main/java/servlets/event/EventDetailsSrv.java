package servlets.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.event.Event;
import model.feedback.Feedback;
import model.user.User;
import service.category.CategoryService;
import service.event.EventServiceImpl;
import service.feedback.FeedbackServiceImpl;
import service.user.UserServiceImpl;

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
			int user_id = (int)(session.getAttribute("id"));
			int event_id = Integer.parseInt(request.getParameter("id"));
			
			// Details for event
			Event event = EventServiceImpl.getEventByID(event_id);
			
			// Feedbacks for event
			ArrayList<Feedback> feedbacks = FeedbackServiceImpl.getFeedbackByEventID(event_id);
			
			UserServiceImpl usimp = new UserServiceImpl();
			User event_manager = usimp.getUserByID(user_id);
			
			request.setAttribute("event_manager", event_manager);
			request.setAttribute("event", event);
			request.setAttribute("feedbacks", feedbacks);
			
			request.setAttribute("category", CategoryService.getCategoryByID(event.getCategoryId()));
			
			request.getRequestDispatcher("/WEB-INF/views/event/eventDetails.jsp").forward(request, response);
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
