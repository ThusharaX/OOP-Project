package servlets.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.event.EventServiceImpl;
import service.ticket.TicketServiceImpl;

/**
 * Servlet implementation class DeleteTicketSrv
 */
@WebServlet("/delete-ticket")
public class DeleteTicketSrv extends HttpServlet {
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
			int ticket_id = Integer.parseInt(request.getParameter("tid"));
			
			TicketServiceImpl.deleteTicket(ticket_id);
			
			response.sendRedirect("/dashboard");
		}
	}

}
