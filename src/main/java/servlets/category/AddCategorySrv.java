package servlets.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.category.Category;
import service.category.CategoryService;

/**
 * Servlet implementation class AddCategorySrv
 */
@WebServlet("/AddCategory")
public class AddCategorySrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategorySrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/category/AddCategory.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		
		Category category = new Category (name,description);
		CategoryService.AddCateory(category);
		
		
		
		response.sendRedirect("/dashboard");
	}

}
