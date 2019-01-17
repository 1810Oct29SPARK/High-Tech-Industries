package project2.hightechindustries.dao;

import java.io.File;
import java.util.List;

import project2.hightechindustries.beans.Users;

public interface UserDAO {
	
	/**
	 * @author (name="SBG")
	 * This method is our login method, it will check a username and password against the database then return user info
	 */
	public Users findUser(Users namePass);
	
	
	/**
	 * @author (name=Esteban) (for method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that a member (particularly an employee member) can view any particular client member.
	 */
	public Users getUserById(int id);
	
	/**
	 * @author (name=Esteban) (for method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that a member (particularly an employee member) can view a list of all other members.
	 */
	public List<Users> getAllUsers();
	
	/**
	 * @author (name=Esteban) (for method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so when a visitor becomes a member, he/she is added to the list of members.
	 */
	public void addUser(Users user);
	
	/**
	 * @author (name=Esteban) (for method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members can update their information.
	 */
	public void updateUser(Users user);
	
	/**
	 * @author (name=Sean)
	 * Here I want to make a separate method for users updating their profile pictures
	 *  just since it seems like it's more complicated than updating the rest of their
	 *  information.
	 * If it turns out I'm wrong and we'd be better off combining this with the regular
	 *  updateUser method (above), we can go ahead and do that instead.
	 * But for now:
	 */
	
//	public void updateProfilePhoto(File photo, int memberId);
	
	/**
	 * @author (name=Esteban) (for method)
	 * @author (name=Sean) (for JavaDoc)
	 * This method is here so that members can be deleted from the system if they decide to cancel their membership.
	 */
	public void deleteUser(Users user);

}
