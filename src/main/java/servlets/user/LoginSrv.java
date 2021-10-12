package servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user.User;
import service.user.LoginServiceImpl;
import service.user.UserServiceImpl;

@WebServlet("/login")
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") != null){
			response.sendRedirect("/profile");
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Validation
		boolean isValid = LoginServiceImpl.validate(email, password);
		
		if (isValid) {
			UserServiceImpl usimp = new UserServiceImpl();
			User user = usimp.getUserByEmail(email);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", user.getId());
			session.setAttribute("fname", user.getFname());
			session.setAttribute("role", user.getRole());
			
			//setting session to expiry in 60 mins
			session.setMaxInactiveInterval(60*60);
			
			response.sendRedirect("/");
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
		}
		
	}

}
