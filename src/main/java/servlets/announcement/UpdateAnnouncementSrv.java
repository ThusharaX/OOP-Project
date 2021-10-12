package servlets.announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.announcement.Announcement;
import service.announcement.AnnouncementServiceImpl;

/**
 * Servlet implementation class UpdateAnnouncementSrv
 */
@WebServlet("/update-announcement")
public class UpdateAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aid = Integer.parseInt(request.getParameter("aid"));
		
		Announcement announcement = AnnouncementServiceImpl.getAnnouncementByID(aid);
		
		request.setAttribute("announcement", announcement);
		
		request.getRequestDispatcher("/WEB-INF/views/announcement/updateannouncement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int aid = Integer.parseInt(request.getParameter("aid"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			Announcement announcement = new Announcement(aid, title, description);
			boolean isSuccess = AnnouncementServiceImpl.updateannouncement(announcement);
			
			if(isSuccess) {
				response.sendRedirect("/dashboard");
			}
		}
	}

}
