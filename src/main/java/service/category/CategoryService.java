/**
 * 
 */
package service.category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.category.Category;
import util.DBConnect;

/**
 * @author Gaween Kanishka
 *
 */

public class CategoryService {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static  ArrayList<Category> getCategories(){
		
		ArrayList<Category> categories = new ArrayList<>();
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM category";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3); 
								
				Category  c = new Category(id,name,description);
				
				categories.add(c);
				//System.out.println(name);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return categories;
		
	}
	
	
	
	
	

}
