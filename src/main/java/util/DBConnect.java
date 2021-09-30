package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static String url = "jdbc:mysql://eu-cdbr-west-01.cleardb.com/heroku_fb072d8cac3df9f";
	private static String user = "b30683c7106749";
	private static String pass = "ed955783";
    private static Connection con;
    
    public static Connection getConnection() {
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	con = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        return con;
    }
}
