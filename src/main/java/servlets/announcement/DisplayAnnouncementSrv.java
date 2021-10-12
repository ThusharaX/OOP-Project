package servlets.announcement;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.announcement.Announcement;
import service.announcement.AnnouncementServiceImpl;

/**
 * Servlet implementation class UserDisplayAnnouncementSrv
 */
@WebServlet("/announcements")
public class DisplayAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Announcement> announcements = AnnouncementServiceImpl.getAnnouncements();
		
		request.setAttribute("announcements", announcements);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/announcement/DisplayAnnouncement.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
