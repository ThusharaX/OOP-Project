package servlets.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.event.Event;
import model.ticket.Ticket;
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
			
//			Get event by ID
			Event event = EventServiceImpl.getEventByID(event_id);
			String expiry_date = event.getDate();
			
//			Reduce ticket count by one
			int ticketCount = event.getAvailableTickets() - 1;
			EventServiceImpl.updateAvailableTickets(ticketCount, event_id);
			
//			Update Available Tickets in event
			
			
			Ticket ticket= new Ticket(event_id, user_id, expiry_date);
			
			TicketServiceImpl.createTicket(ticket);
			
			response.sendRedirect("/eventDetails?id=" + event_id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
