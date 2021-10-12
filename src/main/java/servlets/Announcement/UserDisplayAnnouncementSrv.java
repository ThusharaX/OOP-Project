package servlets.Announcement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.announcement.announcement;
import model.event.Event;
import service.announcement.announcementServiceImpl;
import service.event.EventServiceImpl;
/**
 * Servlet implementation class UserDisplayAnnouncementSrv
 */
@WebServlet("/displayannouncement")



public class UserDisplayAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<announcement> announcements = announcementServiceImpl.getAnnouncement();
		
		
		request.setAttribute("announcements", announcements);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/announcement/DisplayAnnouncement.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
				
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncement();
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("adminpage.jsp");
			dis.forward(request, response);
		
	}

}
