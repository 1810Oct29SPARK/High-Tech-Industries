package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Users;

public interface UserDAO {
	
	public Users getUserById(int id);
	public List<Users> getAllUsers();
	public void addUser(Users user);
	public void updateUser(Users user);
	public void deleteUser(Users user);

}
