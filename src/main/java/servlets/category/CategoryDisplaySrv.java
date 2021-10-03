package servlets.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.category.Category;
import service.category.CategoryService;

/**
 * Servlet implementation class CategoryDisplaySrv
 */
@WebServlet("/categories")
public class CategoryDisplaySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Category> categories = CategoryService.getCategories();
		
		request.setAttribute("categories", categories);
		getServletContext().getRequestDispatcher("/WEB-INF/views/category/CategoryDisplay.jsp").forward(request, response);
		
	}


}
