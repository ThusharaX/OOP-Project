package servlets.feedback;

import java.io.IOException;
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
@WebServlet("/Update-feedback")
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
			response.sendRedirect("/feedback");
		}
		else {
			int user_id = (int)(session.getAttribute("id"));
			
			FeedbackServiceImpl feedbackserviceimpl = new FeedbackServiceImpl();
			Feedback feedback = feedbackserviceimpl.getFeedbackByID(user_id);
			
			request.setAttribute("feedback", feedback);
			
			request.getRequestDispatcher("/WEB-INF/views/feedback/update-feedback.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = (int)(session.getAttribute("id")); 
		
		int event_id =Integer.parseInt (request.getParameter("event_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String description = request.getParameter("description");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String created_at = request.getParameter("created_at");
		
		
		Feedback feedback = new Feedback(id, event_id, user_id, description, rating, created_at);
		
		FeedbackServiceImpl fbimp = new FeedbackServiceImpl();
		fbimp.updateFeedback(feedback);
		
		session.setAttribute("event_id", event_id);
		
		response.sendRedirect("/feedback");
	
	}

}
