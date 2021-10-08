/**
 * 
 */
package service.event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.event.Event;
import util.DBConnect;

/**
 * @author ThusharaThiwanka
 *
 */
public class EventServiceImpl {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static ArrayList<Event> getEvents() {
		
		ArrayList<Event> events = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Event";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				String date = rs.getString(4);
				String time = rs.getString(5);
				int available_tickets = rs.getInt(6);
				int event_manager_id = rs.getInt(7);
				int status = rs.getInt(8);
				int online_event = rs.getInt(9);
				int category_id = rs.getInt(10);
				String venue = rs.getString(11);
				
				Event e = new Event(id, name, description, date, time, available_tickets, event_manager_id, status, online_event, category_id, venue);
				
				events.add(e);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return events;
	}
	
	public static Event getEventByID(int event_id) {

		Event event = new Event();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM event WHERE id = '" + event_id + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				event.setId(rs.getInt("id"));
				event.setName(rs.getString("name"));
				event.setDescription(rs.getString("description"));
				event.setDate(rs.getString("date"));
				event.setTime(rs.getString("time"));
				event.setAvailableTickets(rs.getInt("available_tickets"));
				event.setEventManagerId(rs.getInt("event_manager_id"));
				event.setStatus(rs.getInt("status"));
				event.setOnlineEvent(rs.getInt("online_event"));
				event.setCategoryId(rs.getInt("category_id"));
				event.setVenue(rs.getString("venue"));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return event;
		
	}
	
	public static ArrayList<Event> searchEvents(String search) {
		
		ArrayList<Event> events = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM Event WHERE name LIKE '%" + search + "%'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				String date = rs.getString(4);
				String time = rs.getString(5);
				int available_tickets = rs.getInt(6);
				int event_manager_id = rs.getInt(7);
				int status = rs.getInt(8);
				int online_event = rs.getInt(9);
				int category_id = rs.getInt(10);
				String venue = rs.getString(11);
				
				Event e = new Event(id, name, description, date, time, available_tickets, event_manager_id, status, online_event, category_id, venue);
				
				events.add(e);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return events;
	}
	
	public static void updateAvailableTickets(int ticketCount, int eventID) {
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "UPDATE `event` SET `available_tickets`='" + ticketCount + "'WHERE `id`='" + eventID + "';";
			stmt.executeUpdate(sql);
		}
		catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
		
	}
}
