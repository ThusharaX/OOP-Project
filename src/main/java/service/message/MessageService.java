package service.message;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.message.Message;
import util.DBConnect;

//################################# Display message ########################################
public class MessageService {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static  ArrayList<Message> getMessages(){
		
		ArrayList<Message> messages = new ArrayList<>();
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM message";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email  = rs.getString(3);
				String subject = rs.getString(4);
				String message	= rs.getString(5);
				String create_at = rs.getString(6);
				
				Message  c = new Message(id,name,email,subject,message,create_at);
				
				messages.add(c);
				//System.out.println(name);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return messages;	
	}
//########################################### Add Message ########################################

	
		
		public static void AddMessage(Message message) {
		
			try {
				con = DBConnect.getConnection();
				stmt = con.createStatement();
				String sql = "INSERT INTO `message` (`name`, `email`, `subject`, `message`) VALUES ('" + message.getName() + "', '" + message.getEmail() + "', '" + message.getSubject()+ " ' ,'"+ message.getMessage()+"');";
				stmt.executeUpdate(sql);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}		
		}				
	}

//############################################# Update Message ####################################
