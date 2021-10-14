package servlets.feedback;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.feedback.Feedback;
import service.feedback.FeedbackServiceImpl;



/**
 * Servlet implementation class UpdateFeedbackSrv
 */
@WebServlet("/update-feedback")
public class UpdateFeedbackSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int feedback_id = Integer.parseInt(request.getParameter("fid"));
			
			Feedback feedback = FeedbackServiceImpl.getFeedbackByFeedbackID(feedback_id);
			
			request.setAttribute("feedback", feedback);
			
			request.getRequestDispatcher("/WEB-INF/views/feedback/update-feedback.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt (request.getParameter("fid"));
		int event_id = Integer.parseInt (request.getParameter("eid"));
		int user_id = (int) session.getAttribute("id");
		String description = request.getParameter("description");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		Feedback feedback = new Feedback(id, event_id, user_id, description, rating);
		
		FeedbackServiceImpl.updateFeedback(feedback);
		
		response.sendRedirect("/dashboard");
	
	}

}
