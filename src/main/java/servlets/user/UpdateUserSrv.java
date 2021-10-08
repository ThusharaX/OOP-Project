package servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.User;
import service.user.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserSrv
 */
@WebServlet("/update-user")
public class UpdateUserSrv extends HttpServlet {
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
			User user = userserviceimpl.getUserByID(user_id);
			
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("/WEB-INF/views/user/update-user.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id = (int)(session.getAttribute("id")); 
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String NIC = request.getParameter("NIC");
		
		User user = new User(id, fname, lname, email, mobile, address, NIC);
		
		UserServiceImpl usimp = new UserServiceImpl();
		usimp.updateUser(user);
		
		session.setAttribute("fname", fname);
		
		response.sendRedirect("/profile");
	}

}
