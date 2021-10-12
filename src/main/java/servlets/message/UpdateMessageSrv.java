package servlets.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.message.Message;
import service.message.MessageService;

/**
 * Servlet implementation class UpdateMessageSrv
 */
@WebServlet("/update-message")
public class UpdateMessageSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		Message message = MessageService.getMessageByID(mid);
				
		request.setAttribute("message", message);
		
		request.getRequestDispatcher("/WEB-INF/views/message/UpdateMessage.jsp").forward(request, response);
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
			int mid = Integer.parseInt(request.getParameter("mid"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String subject = request.getParameter("subject");
			String ms = request.getParameter("message");
			
			Message message = new Message(mid, name, email, subject, ms);
			MessageService.updateMessage(message);
			
			response.sendRedirect("/messages");
		}
	}

}
