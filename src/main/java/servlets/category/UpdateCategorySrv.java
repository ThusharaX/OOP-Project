package servlets.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.category.Category;
import service.category.CategoryService;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategorySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateCategorySrv() {
     
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
    	int category_id = Integer.parseInt(request.getParameter("cid"));
		
		Category category = CategoryService.getCategoryByID(category_id);
		request.setAttribute("category", category);
		System.out.println(category.getName());
		request.getRequestDispatcher("/WEB-INF/views/category/UpdateCategory.jsp").forward(request, response);
			}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt (request.getParameter("cid"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
	
		
		Category category = new Category(id,name , description);
		
		CategoryService usimp = new CategoryService();
		usimp.UpdateCategory(category);
		
		response.sendRedirect("/categories");
	}	
}
		