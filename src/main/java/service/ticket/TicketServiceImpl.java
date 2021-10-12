/**
 * 
 */
package service.ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


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
	
	
	// Add ticket
	
	public static void createTicket(Ticket ticket) {
	
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO `ticket` ( `event_id`, `user_id`, `expiry_date`) VALUES  ('" + ticket.getEvent_id() + "', '" + ticket.getUser_id() + "', '" + ticket.getExpiry_date() + "');";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	// Display ticket

	public static ArrayList<Ticket> getTickets() {
		
		 ArrayList<Ticket> tickets = new ArrayList<>();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM Ticket";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					int id = rs.getInt(1);
					int event_id = rs.getInt(2);
					int user_id = rs.getInt(3);
					String expiry_date = rs.getString(4);
					
		
					Ticket t = new Ticket(id, event_id, user_id,expiry_date);
					
					tickets.add(t);
				}
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return tickets;
		
		}
	
	
}