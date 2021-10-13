package servlets.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.announcement.Announcement;
import model.category.Category;
import model.event.Event;
import model.feedback.Feedback;
import service.announcement.AnnouncementServiceImpl;
import service.category.CategoryService;
import service.event.EventServiceImpl;
import service.feedback.FeedbackServiceImpl;
import servlets.category.CategoryDisplaySrv;

/**
 * Servlet implementation class DashboardSrv
 */
@WebServlet("/dashboard")
public class DashboardSrv extends HttpServlet {
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
			int user_id = (int) session.getAttribute("id");
			System.out.println(user_id);
			
			if(session.getAttribute("role").equals("admin")){
				
				ArrayList<Announcement> announcements = AnnouncementServiceImpl.getAnnouncements();
				ArrayList<Category> categories = CategoryService.getCategories();
				
				request.setAttribute("announcements", announcements);
				request.setAttribute("categories", categories);
			}
			else if(session.getAttribute("role").equals("event_manager")){
				
				// Get events for Event Manager
				ArrayList<Event> events = EventServiceImpl.getEventsByUserId(user_id);				
				request.setAttribute("events", events);
			}
			else if(session.getAttribute("role").equals("attendee")){
				
				// Data for attendee dashboard
			}
			
			request.getRequestDispatcher("/WEB-INF/views/user/dashboard.jsp").forward(request, response);
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
