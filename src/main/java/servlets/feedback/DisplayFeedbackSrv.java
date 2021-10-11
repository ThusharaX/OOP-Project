package servlets.feedback;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.feedback.Feedback;
import service.feedback.FeedbackServiceImpl;

/**
 * Servlet implementation class DisplayFeedbackSrv
 */
@WebServlet("/feedbacks")
public class DisplayFeedbackSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         ArrayList<Feedback> feedbacks = FeedbackServiceImpl.getFeedbacks();
		
		 request.setAttribute("feedbacks", feedbacks);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/feedback/displayFeedback.jsp").forward(request, response);
	 }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
