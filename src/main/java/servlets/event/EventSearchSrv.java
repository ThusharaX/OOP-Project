package servlets.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.event.Event;
import service.event.EventServiceImpl;


@WebServlet("/search")
public class EventSearchSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Reference
		// https://initialcommit.com/blog/how-to-send-data-from-servlet-to-jsp
		
		String search = request.getParameter("q");
		
		ArrayList<Event> events = EventServiceImpl.searchEvents(search);
		
		request.setAttribute("events", events);
		request.setAttribute("result", search);
		
		request.getRequestDispatcher("/WEB-INF/views/event/searchResult.jsp").forward(request, response);
	}

}
