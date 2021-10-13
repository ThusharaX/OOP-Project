package servlets.ticket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ticket.Ticket;
import service.ticket.TicketServiceImpl;

/**
 * Servlet implementation class UpdateTicketSrv
 */
@WebServlet("/update-ticket")
public class UpdateTicketSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ticket_id = Integer.parseInt(request.getParameter("tid"));
		
		Ticket ticket = TicketServiceImpl.getTicketByID(ticket_id);
				
		request.setAttribute("ticket", ticket);
		
		request.getRequestDispatcher("/WEB-INF/views/ticket/update-ticket.jsp").forward(request, response);
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
			int ticket_id = Integer.parseInt(request.getParameter("tid"));
			int event_id = Integer.parseInt(request.getParameter("eid"));
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			
			Ticket ticket = new Ticket(ticket_id, event_id, user_id);
			TicketServiceImpl.updateTicket(ticket);
			
			response.sendRedirect("/dashboard");
		}
	}

}
