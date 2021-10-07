/**
 * 
 */
package service.user;

import java.util.ArrayList;

import model.user.User;

/**
 * @author ThusharaThiwanka
 *
 */
public interface UserService {
	
	public ArrayList<User> getUsers();
	public boolean checkUserExist(String email);
	public User getUserByEmail(String email);
	public void addUser(User user);
	public User getUserByID(int user_id);
	public void updateUser(User user);
	public void deleteUser(int user_id);
}
