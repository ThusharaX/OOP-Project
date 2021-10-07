package servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.user.UserServiceImpl;

/**
 * Servlet implementation class DeleteUserSrv
 */
@WebServlet("/delete-user")
public class DeleteUserSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			int user_id = (int)(session.getAttribute("id"));
			
			UserServiceImpl userserviceimpl = new UserServiceImpl();
			userserviceimpl.deleteUser(user_id);
			
			response.sendRedirect("/logout");
		}
	}

}
