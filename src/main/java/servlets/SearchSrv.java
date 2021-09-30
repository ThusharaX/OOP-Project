package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")
public class SearchSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Reference
		// https://initialcommit.com/blog/how-to-send-data-from-servlet-to-jsp
		
		String search = request.getParameter("q");
		
		request.setAttribute("result", search);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
	}

}
