package project2.hightechindustries.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

@Service
public class LoginService {
	
	/**
	 * @author (name=Sean)
	 * This is the LoginService.
	 * The purpose of this service is to log people in, both employee members and customer members,
	 *  create a session when they're logged in, log them out, and end the session when they log out.
	 */
	
	/**
	 * Login	X
	 * Logout	X
	 */
	
	private ObjectMapper om = new ObjectMapper();
	
	public String findUser(String username, String password) {
		Users currentUser = null;
		UserDAO ud = new UserDAOImpl();
		
		return currentUser.toString();
	}
	
}