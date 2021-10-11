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

import service.announcement.announcementServiceImpl;
import service.category.CategoryService;
import  model.announcement.announcement;
import model.category.Category;

/**
 * Servlet implementation class AddAnnouncementSrv
 */
@WebServlet("/addAnnouncement")




public class AddAnnouncementSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final announcementServiceImpl AnnouncementServiceImpl = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<announcement> announcements = announcementServiceImpl.getAnnouncement();
		
		request.setAttribute("announcements", announcements);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/announcement/announcementinsert.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String created_at = request.getParameter("created_at");
		
		
		
		boolean isTrue;
		
       isTrue = announcementServiceImpl.insertannouncement(title, description, created_at);
		
		if(isTrue == true) {
			
			List<announcement> cusDetails = announcementServiceImpl.getAnnouncement();
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("adminpage.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}   
		
	}

}
