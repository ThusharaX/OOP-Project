/**
 * 
 */
package service.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import util.DBConnect;

/**
 * @author ThusharaThiwanka
 *
 */
public class UserServiceImpl implements UserService {
	
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	@Override
	public ArrayList<User> getUsers() {
		
		ArrayList<User> users = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM User";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3); 
				String email = rs.getString(4);
				String password = rs.getString(5);
				String mobile = rs.getString(6);
				String address = rs.getString(7);
				String join_date = rs.getString(8);
				String NIC = rs.getString(9);
				String role = rs.getString(10);
				
				User u = new User(id, fname, lname, email, password, mobile, address, join_date, NIC, role);
				
				users.add(u);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	@Override
	public boolean checkUserExist(String email) {
		
		boolean isExist = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM User WHERE email = '" + email + "'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next() == true) {
				isExist = true;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isExist;
	}

	@Override
	public User getUserByEmail(String em) {
		User user = new User();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE email = '" + em + "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				user.setJoin_date(rs.getString("join_date"));
				user.setNIC(rs.getString("NIC"));
				user.setRole(rs.getString("role"));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

}
