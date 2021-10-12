/**
 * 
 */
package service.feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import model.feedback.Feedback;
import model.user.User;
import util.DBConnect;

/**
 * @author ThusharaThiwanka
 *
 */
public class FeedbackServiceImpl {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	
	// Create feedback
	
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

	// Display All feedback
	
	public static ArrayList<Feedback> getFeedbacks(){
		
		 ArrayList<Feedback> feedbacks = new ArrayList<>();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM Feedback";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt(1);
					int event_id = rs.getInt(2);
					int user_id = rs.getInt(3);
					String description = rs.getString(4);
					int rating = rs.getInt(5);
					String created_at = rs.getString(6);
		
					Feedback f = new Feedback(id, event_id, user_id,description, rating, created_at);
					
					feedbacks.add(f);
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return feedbacks;
		
	}

	// getFeedback by user ID
	public static ArrayList<Feedback> getFeedbackByUserID(int user_id) {
		
		ArrayList<Feedback> feedbacks = new ArrayList<>();
        
        try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Feedback WHERE user_id = '" + user_id + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				int event_id = rs.getInt(2);
				int uid = rs.getInt(3);
				String description = rs.getString(4);
				int rating = rs.getInt(5);
				String created_at = rs.getString(6);
	
				Feedback f = new Feedback(id, event_id, uid,description, rating, created_at);
				
				feedbacks.add(f);
			}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		
		return feedbacks;
	}
	
	
	// getFeedback by user ID
	public static ArrayList<Feedback> getFeedbackByEventID(int event_id) {
			
		ArrayList<Feedback> feedbacks = new ArrayList<>();
	        
	    try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Feedback WHERE event_id = '" + event_id + "'";
			rs = stmt.executeQuery(sql);
				
			while (rs.next()) {
				int id = rs.getInt(1);
				int eid = rs.getInt(2);
				int uid = rs.getInt(3);
				String description = rs.getString(4);
				int rating = rs.getInt(5);
				String created_at = rs.getString(6);
		
				Feedback f = new Feedback(id, eid, uid,description, rating, created_at);
					
				feedbacks.add(f);
			}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
			
		return feedbacks;
	}
		
	
	// Update Feedback
	public static void updateFeedback(Feedback feedback) {
			
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE `feedback` SET `id`='" + feedback.getId() + "', `event_id`='" + feedback.getEvent_id() + "', `user_id`='" + feedback.getUser_id() + "', `description`='" + feedback.getDescription() + "', `rating`='" + feedback.getRating() + "' WHERE `id`='" + feedback.getId() + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
			
	}
	
	
	// getFeedback by user ID AND event ID
	public static ArrayList<Feedback> getFeedbackByEventIDandUserID(int event_id, int user_id) {
		
		ArrayList<Feedback> feedbacks = new ArrayList<>();
	        
	    try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Feedback WHERE event_id = '" + event_id + "' AND user_id = '" + user_id + "';";
			rs = stmt.executeQuery(sql);
				
			while (rs.next()) {
				int id = rs.getInt(1);
				int eid = rs.getInt(2);
				int uid = rs.getInt(3);
				String description = rs.getString(4);
				int rating = rs.getInt(5);
				String created_at = rs.getString(6);
		
				Feedback f = new Feedback(id, eid, uid,description, rating, created_at);
					
				feedbacks.add(f);
			}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
			
		return feedbacks;
	}
	
	
	// getFeedback by feedback ID
		public static Feedback getFeedbackByFeedbackID(int feedback_id) {
				
		Feedback feedback = new Feedback();
		        
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Feedback WHERE id = '" + feedback_id + "'";
			rs = stmt.executeQuery(sql);
					
			while (rs.next()) {
				feedback.setId(rs.getInt("id"));
				feedback.setEvent_id(rs.getInt("event_id"));
				feedback.setUser_id(rs.getInt("user_id"));
				feedback.setDescription(rs.getString("description"));
				feedback.setRating(rs.getInt("rating"));
				feedback.setCreated_at(rs.getString("created_at"));
			}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
				
		return feedback;
	}

	
	public static void deleteFeedback(int fid) {
			
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM `feedback` WHERE `id`='" + fid + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}
}