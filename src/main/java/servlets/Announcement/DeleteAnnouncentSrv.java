package servlets.Announcement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  model.announcement.announcement;
import service.announcement.announcementServiceImpl;

/**
 * Servlet implementation class DeleteAnnouncementSrv
 */
@WebServlet("/DeleteAnnouncementSrv")


public class DeleteAnnouncentSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("cusid");
		boolean isTrue;
		
		isTrue = announcementServiceImpl.deleteannouncement(id);
		
		if (isTrue == true) {
			
			
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncement();
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncementDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminpage.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	}

}
