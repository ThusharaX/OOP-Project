package servlets.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.category.CategoryService;

/**
 * Servlet implementation class DeleteCategorySrv
 */
@WebServlet("/DeleteCategory")
public class DeleteCategorySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/categories");
		}
		else {
			int category_id = Integer.parseInt(request.getParameter("cid"));
			
			CategoryService.DeleteCategory(category_id);
			
			response.sendRedirect("/categories");
		
	}
	}
}
