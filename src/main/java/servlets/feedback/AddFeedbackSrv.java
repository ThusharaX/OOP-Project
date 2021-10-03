package servlets.feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feedback.Feedback;
import service.feedback.FeedbackServiceImpl;

/**
 * Servlet implementation class AddFeedbackSrv
 */
@WebServlet("/add-feedback")
public class AddFeedbackSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/feedback/addFeedback.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int event_id = Integer.parseInt(request.getParameter("event_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String description = request.getParameter("description");
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		Feedback feedback = new Feedback(event_id, user_id, description, rating);
		
		FeedbackServiceImpl.createFeedback(feedback);
		
		response.sendRedirect("/add-feedback");
	}

}
