package servlets.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.event.Attendee;
import model.event.Event;
import model.user.User;
import service.event.AttendeeServiceImpl;
import service.event.EventServiceImpl;
import service.user.UserServiceImpl;

/**
 * Servlet implementation class ProfileSrv
 */
@WebServlet("/profile")
public class ProfileSrv extends HttpServlet {
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
			
			UserServiceImpl userserviceimpl = new UserServiceImpl();
			User user = userserviceimpl.getUserByID(user_id);
			
//			Get Attendees for user
			ArrayList<Attendee> attendees = AttendeeServiceImpl.getAttendeeByUserId(user_id);
			
//			ArrayList<Integer> eventIDs = new ArrayList<>(attendees.size());
			ArrayList<Event> eventsForAttendee = new ArrayList<>(attendees.size());
			
			for(Attendee attendee : attendees)
		    {
				eventsForAttendee.add(EventServiceImpl.getEventByID(attendee.getEvent_id()));
		    }
						
			request.setAttribute("eventsForAttendee", eventsForAttendee);
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("/WEB-INF/views/user/profile.jsp").forward(request, response);
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
