package servlets.ticket;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ticket.Ticket;
import service.ticket.TicketServiceImpl;

/**
 * Servlet implementation class DisplayTicketSrv
 */
@WebServlet("/tickets")
public class DisplayTicketSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Ticket> tickets = TicketServiceImpl.getTickets();
		
		request.setAttribute("tickets", tickets);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/ticket/displayTicket.jsp").forward(request, response);
	}
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
