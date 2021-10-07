package servlets.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ticket.Ticket;
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
		getServletContext().getRequestDispatcher("/WEB-INF/views/ticket/addTicket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int event_id =Integer.parseInt (request.getParameter("event_id"));
		int user_id =Integer.parseInt( request.getParameter("user_id"));
		String expiry_date = request.getParameter("expiry_date");
		
		Ticket ticket= new Ticket(event_id, user_id,expiry_date );
		
		TicketServiceImpl.createTicket(ticket);
		
		response.sendRedirect("/");
	}

}
