package servlets.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.category.Category;
import service.category.CategoryService;

/**
 * Servlet implementation class UpdateCategorySrv
 */
@WebServlet("/update-category")
public class UpdateCategorySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));
		
		Category category = CategoryService.getCategoryByID(cid);

		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/WEB-INF/views/category/UpdateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//allow access only if session exists
		if(session.getAttribute("id") == null){
			response.sendRedirect("/login");
		}
		else {
			int cid = Integer.parseInt(request.getParameter("cid"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			Category category = new Category(cid, name, description);
			CategoryService.updateCategory(category);
			
			response.sendRedirect("/categories");
		}
	}

}
