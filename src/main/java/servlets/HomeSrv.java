package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.User;
import service.user.UserServiceImpl;



@WebServlet("")
public class HomeSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceImpl userserviceimpl = new UserServiceImpl();
		ArrayList<User> users = userserviceimpl.getUsers();

		request.setAttribute("users", users);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
