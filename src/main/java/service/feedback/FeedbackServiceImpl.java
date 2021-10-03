/**
 * 
 */
package service.feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.feedback.Feedback;
import util.DBConnect;

/**
 * @author ThusharaThiwanka
 *
 */
public class FeedbackServiceImpl {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static void createFeedback(Feedback feedback) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO `feedback` (`event_id`, `user_id`, `description`, `rating`) VALUES ('" + feedback.getEvent_id() + "', '" + feedback.getUser_id() + "', '" + feedback.getDescription() + "', '" + feedback.getRating() + "');";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
