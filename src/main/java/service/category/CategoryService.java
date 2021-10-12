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
//################################# Display category ########################################
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
	
	
//########################################### Add Category #######################
	
	
		
		public static void AddCateory(Category category) {
		
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "INSERT INTO `category` (`name`, `description`) VALUES ('" + category.getName() + "', '" + category.getDiscription() +"');";
				stmt.executeUpdate(sql);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}		
		}
		
//############################################# Update Category ##################

		public static void UpdateCategory(Category category) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE `category` SET `name`='" + category.getName() + "', `description`='" + category.getDiscription()+"' WHERE `id`='" + category.getId() + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		
	}
//########################################### Delete Category  ###################


		public static void DeleteCategory(int category_id) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM `category` WHERE `id`='" + category_id + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}
//###################################################################################

		public static Category getCategoryByID(int category_id) {
			
			Category category = new Category();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM category WHERE id = '" + category_id + "'";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setDiscription(rs.getString("discription"));
					
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return category;
		}
}
//##################################################################################









