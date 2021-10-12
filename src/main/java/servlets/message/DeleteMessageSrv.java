package servlets.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.message.MessageService;

/**
 * Servlet implementation class DeleteMessageSrv
 */
@WebServlet("/DeleteMessage")
public class DeleteMessageSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/messages");
		}
		else {
			int message_id = Integer.parseInt(request.getParameter("mid"));
			
			MessageService.DeleteMessage(message_id);
			
			response.sendRedirect("/messages");
		}
		
	}

}
