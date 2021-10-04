package servlets.message;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.message.Message;
import service.message.MessageService;


@WebServlet("/messages")
public class DisplayMessagesSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DisplayMessagesSrv() {
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Message> messages = MessageService.getMessages();
		
		request.setAttribute("messages", messages);
		getServletContext().getRequestDispatcher("/WEB-INF/views/message/DisplayMessage.jsp").forward(request, response);
		
		
		
		
		
	}

}
