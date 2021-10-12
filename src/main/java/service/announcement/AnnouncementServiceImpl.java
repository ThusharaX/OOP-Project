package service.announcement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.announcement.Announcement;
import util.DBConnect;

/**
 * @author NikethaniGangoda
 *
 */

public class AnnouncementServiceImpl {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
    public static ArrayList<Announcement> getAnnouncements() {
		
		ArrayList<Announcement> announcements = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from announcement ";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				String created_at = rs.getString(4);
				
				Announcement cus = new Announcement(id, title, description, created_at);
				announcements.add(cus);
			}
			
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		
		return announcements;	
	}
    
 
    public static void insertAnnouncement(Announcement announcement){
    	
    	try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO `announcement` (`title`, `description`) VALUES ('" + announcement.getTitle() + "', '" + announcement.getDescription() + "');";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
    }
    
    
    public static boolean updateannouncement(Announcement announcement) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "UPDATE `announcement` SET `title`='" + announcement.getTitle() + "',`description`='" + announcement.getDescription() + "' WHERE `id`='" + announcement.getId() + "';";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
   
    public static boolean deleteAnnouncement(int aid) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "DELETE FROM `announcement` WHERE `id`='" + aid + "';";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }


	public static Announcement getAnnouncementByID(int announcement_id) {
		Announcement A = new Announcement();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM announcement WHERE id = '" + announcement_id + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				A.setId(rs.getInt("id"));
				A.setTitle(rs.getString("title"));
				A.setCreated_at(rs.getString("created_at"));
				A.setDescription(rs.getString("description"));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return A;	
	}		
}