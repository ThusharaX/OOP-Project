/**
 * 
 */
package service.user;

import java.util.ArrayList;

import model.User;

/**
 * @author ThusharaThiwanka
 *
 */
public interface UserService {
	
	public ArrayList<User> getUsers();
	public boolean checkUserExist(String email);
	public User getUserByEmail(String email);
}
