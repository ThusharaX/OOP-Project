/**
 * 
 */
package service.ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ticket.Ticket;
import util.DBConnect;

/**
 * @author Dilki
 *
 */
public class TicketServiceImpl {

	static Connection con = null;
	static Statement stmt = null;        
	static ResultSet rs = null;
	
	public static void createTicket(Ticket ticket) {
	
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO `ticket` ( `event_id`, `user_id`,'expiry_date') VALUES  ('" + ticket.getEvent_id() + "', '" + ticket.getUser_id() + "', '" + ticket.getExpiry_date() + "');";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


}