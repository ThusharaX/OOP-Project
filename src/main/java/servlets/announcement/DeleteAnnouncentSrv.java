package servlets.announcement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.announcement.AnnouncementServiceImpl;

/**
 * Servlet implementation class DeleteAnnouncementSrv
 */
@WebServlet("/delete-announcement")


public class DeleteAnnouncentSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int aid = Integer.parseInt(request.getParameter("aid"));
			
			boolean isSuccess = AnnouncementServiceImpl.deleteAnnouncement(aid);
			
			if (isSuccess) {
				response.sendRedirect("/dashboard");				
			}
		}
	}

}
