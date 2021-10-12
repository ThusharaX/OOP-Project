package servlets.announcement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.announcement.AnnouncementServiceImpl;
import  model.announcement.Announcement;

/**
 * Servlet implementation class AddAnnouncementSrv
 */
@WebServlet("/create-announcement")




public class AddAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/announcement/announcementinsert.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			Announcement announcement = new Announcement(title, description);
			
			AnnouncementServiceImpl.insertAnnouncement(announcement);
			
			response.sendRedirect("/dashboard");
		}
		
	}

}
