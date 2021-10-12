/**
 * 
 */
package service.event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBConnect;

/**
 * @author ThusharaThiwanka
 *
 */
public class AttendeeServiceImpl {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static void addUserToAttendeeList(int event_id, int user_id) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO `attendee_list` (`event_id`, `attendee_id`) VALUES ('" + event_id + "', '" + user_id + "');";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}
	
	
	public static boolean checkUserInAttendeeList(int event_id, int user_id) {
		
		boolean isAttendee = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM `attendee_list` WHERE event_id = '" + event_id + "' AND attendee_id = '" + user_id + "'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next() == true) {
				isAttendee = true;
			}
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		return isAttendee;
	}
}
