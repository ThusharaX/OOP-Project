package servlets.Announcement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.announcement.announcement;
import model.category.Category;

import service.announcement.announcementServiceImpl;
import service.category.CategoryService;
import service.event.EventServiceImpl;

/**
 * Servlet implementation class UpdateAnnouncementSrv
 */
@WebServlet("/updateAnnouncement")
public class UpdateAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("cusid"));
		
		announcement A = announcementServiceImpl.getAnnouncementByID(id);
		
				

		request.setAttribute("announcements", A);
		
		request.getRequestDispatcher("/WEB-INF/views/announcement/updateannouncement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("cusid");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String created_at = request.getParameter("created_at");
		
		
		boolean isTrue;
		
		isTrue = announcementServiceImpl.updateannouncement(id, title, description, created_at);
		
		if(isTrue == true) {
			
			
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncementDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("adminpage.jsp");
			dis.forward(request, response);
		}
		else {
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncementDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			dis.forward(request, response);
		}
	}

}
