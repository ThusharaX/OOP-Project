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
 * Servlet implementation class UpdateMessage
 */
@WebServlet("/UpdateMessage")
public class UpdateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateMessage() {
    
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int message_id = Integer.parseInt(request.getParameter("mid"));
		
		Message message = MessageService.getMessageByID(message_id);
		request.setAttribute("message", message);
		System.out.println(message.getName());
		request.getRequestDispatcher("/WEB-INF/views/message/UpdateMessage.jsp").forward(request, response);
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = (int)(session.getAttribute("mid")); 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject  = request.getParameter("subject");
		String message = request.getParameter("message");
		
		Message m = new Message(name,email,subject,message);
		
		MessageService usimp = new MessageService();
		usimp.UpdateMessage(m);
		
		response.sendRedirect("/");
	}

}