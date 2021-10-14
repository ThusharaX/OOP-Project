package servlets.ticket;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.event.Event;
import model.message.Message;
import model.ticket.Ticket;
import service.event.AttendeeServiceImpl;
import service.event.EventServiceImpl;
import service.ticket.TicketServiceImpl;

/**
 * Servlet implementation class AddTicketSrv
 */
@WebServlet("/add-ticket")
public class AddTicketSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		getServletContext().getRequestDispatcher("/WEB-INF/views/ticket/addTicket.jsp").forward(request, response);
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int event_id = Integer.parseInt(request.getParameter("eid"));
			int user_id = (int)(session.getAttribute("id"));
			
//			Check if user_id is in attendee_list for same event
			boolean isAttendee = false;
			isAttendee = AttendeeServiceImpl.checkUserInAttendeeList(event_id, user_id);
			
			if (isAttendee) {
				String alert = "You already attended to this event";
				request.setAttribute("alert", alert);
				
				getServletContext().getRequestDispatcher("/eventDetails?id=" + event_id).forward(request, response);
			}
			else {
//				Get event by ID
				Event event = EventServiceImpl.getEventByID(event_id);
				
//				Get event date == expiry_date
				String expiry_date = event.getDate();
				
//				Reduce ticket count by one
				int ticketCount = event.getAvailableTickets() - 1;
				
//				Update Available Tickets in event
				EventServiceImpl.updateAvailableTickets(ticketCount, event_id);
				
//				Add user to attendee_list
				AttendeeServiceImpl.addUserToAttendeeList(event_id, user_id);
				
				Ticket ticket= new Ticket(event_id, user_id, expiry_date);
				
				TicketServiceImpl.createTicket(ticket);
				
				
				response.sendRedirect("/dashboard");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
