/**
 * 
 */
package service.user;

import model.user.User;

/**
 * @author ThusharaThiwanka
 *
 */
public class LoginServiceImpl {

	public static boolean validate(String email, String password) {
//		DB Validation
		UserServiceImpl usimp = new UserServiceImpl();
		boolean isValid = true;
		boolean isExists = usimp.checkUserExist(email);
		
		User user = usimp.getUserByEmail(email);
		
		if (password.equals(user.getPassword())) {
			isValid = true;
		}
		else {
			isValid = false;
		}
		
		return isValid;
	}

}
