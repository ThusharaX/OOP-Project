/**
 * 
 */
package service.ticket;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.event.Event;
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
	
	// Get Ticket By ID
	public static Ticket getTicketByID(int ticket_id) {

		Ticket ticket = new Ticket();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM ticket WHERE id = '" + ticket_id + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ticket.setId(rs.getInt("id"));
				ticket.setEvent_id(rs.getInt("event_id"));
				ticket.setUser_id(rs.getInt("user_id"));
				ticket.setExpiry_date(rs.getString("expiry_date"));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ticket;
	}
	
	// Update Ticket
	public static void updateTicket(Ticket ticket) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE `ticket` SET `event_id`='" + ticket.getEvent_id() + "',`user_id`='" + ticket.getUser_id() + "', `expiry_date`='" + ticket.getExpiry_date() + "' WHERE `id`='" + ticket.getId() + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		
	}

	// Delete Ticket
	public static void deleteTicket(int tid) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "DELETE FROM `ticket` WHERE `id`='" + tid + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}
	
	
	// Get Ticket By ID
		public static ArrayList<Ticket> getTicketByUserID(int uid) {

			ArrayList<Ticket> tickets = new ArrayList<>();
			
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM Ticket WHERE `user_id`='" + uid + "';";
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