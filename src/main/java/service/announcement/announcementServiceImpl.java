package service.announcement;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.announcement.announcement;
import util.DBConnect;
/**
 * @author NikethaniGangoda
 *
 */

public class announcementServiceImpl {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
    

	
	
    public static ArrayList<announcement> getAnnouncement() {
		
		ArrayList<announcement> Announcement = new ArrayList<>();
		
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
				
				
				
				announcement cus = new announcement(id,title,description,created_at);
				Announcement.add(cus);
			}
			
		} catch (Exception e) {
			
		}
		
		return Announcement;	
	}
    
 
    public static boolean insertannouncement(String title, String description, String created_at){
    	
    	boolean isSuccess = false;
    	
    	try {
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    	    String sql = "insert into announcement values (0,'"+title+"','"+description+"','"+created_at+"')";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		} else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
 	
    	return isSuccess;
    }
    
    public static boolean updateannouncement(int id, String title, String description, String created_at) {
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update announcement set title='"+title+"',description='"+description+"',created_at='"+created_at+"'"
    				+ "where id='"+id+"'";
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
 
    public static List<announcement> getAnnouncementDetails(String Id) {
    	
    	int convertedID = Integer.parseInt(Id);
    	
    	ArrayList<announcement> cus = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from announcement ";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int id = rs.getInt(1);
    			String title = rs.getString(2);
    			String description = rs.getString(3);
    			String created_at = rs.getString(4);
    			
    			
    			
    			announcement c = new announcement(id,title,description,created_at);
    			cus.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	return cus;	
    }
    
    
    public static boolean deleteannouncement(String id) {
    	
    	int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from announcement where id='"+convId+"'";
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


	public static announcement getAnnouncementByID(int announcement_id) {
		announcement A = new announcement();
		
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

