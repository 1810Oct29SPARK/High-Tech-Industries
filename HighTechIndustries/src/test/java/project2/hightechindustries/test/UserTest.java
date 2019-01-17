package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.Test;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

class UserTest {
	
	UserDAO u = new UserDAOImpl();

	/**
	 * @author Esteban
	 * Set the expected object of type Users and fetch data from database
	 */
	@Test
	public void getUser() {
        Users user = new Users();
        user.setId(1);
        user.setFirstName("MARIO");
        user.setLastName("MARIO");
        user.setEmail("mariomario@itsamemario.com");
        user.setPhone("109-876-5432");
        user.setEmployeeStatus("Employee");
        user.setUsername("SUPERMARIO");

        Assert.assertEquals(user, u.getUserById(1));
	}

	/**
	 * @author Esteban
	 * Get a list of all users, have to first create an Object of Users with expected list of all users and then
	 * evaluate whether the returned object with a list of users is correct
	 */
	@Test
	public void listUsers() {
        Users user1 = new Users();
        user1.setId(1);
        user1.setFirstName("MARIO");
        user1.setLastName("MARIO");
        user1.setEmail("mariomario@itsamemario.com");
        user1.setPhone("109-876-5432");
        user1.setEmployeeStatus("Employee");
        user1.setUsername("SUPERMARIO");

        Users user2 = new Users();
        user2.setId(2);
        user2.setFirstName("SONIC");
        user2.setLastName("THE HEDGEHOG");
        user2.setEmail("kingofrings@blueblur.com");
        user2.setPhone("987-654-3210");
        user2.setEmployeeStatus("Customer");
        user2.setHelpedBy(3);
        user2.setUsername("SUPERSONIC");

        Users user3 = new Users();
        user3.setId(3);
        user3.setFirstName("DONKEY");
        user3.setLastName("KONG");
        user3.setEmail("Ooooh@banana.com");
        user3.setPhone("876-543-2109");
        user3.setEmployeeStatus("Employee");
        user2.setHelpedBy(1);
        user3.setUsername("DK");

        Users user4 = new Users();
        user4.setId(4);
        user4.setFirstName("SCOOBY");
        user4.setLastName("DOO");
        user4.setEmail("No Email");
        user4.setPhone("No Phone");
        user4.setEmployeeStatus("Customer");
        user4.setUsername("ROOBYROO");

        Users user5 = new Users();
        user5.setId(5);
        user5.setFirstName("YOGI");
        user5.setLastName("BEAR");
        user5.setEmail("No Email");
        user5.setPhone("No Phone");
        user5.setEmployeeStatus("Customer");
        user5.setUsername("PICNIC BASKET");

        Users user6 = new Users();
        user6.setId(6);
        user6.setFirstName("MEGAMAN");
        user6.setLastName("LIGHT");
        user6.setEmail("No Email");
        user6.setPhone("No Phone");
        user6.setEmployeeStatus("Customer");
        user6.setUsername("ROCK");

        Users user7 = new Users();
        user7.setId(7);
        user7.setFirstName("KIRBY");
        user7.setEmail("No Email");
        user7.setPhone("No Phone");
        user7.setEmployeeStatus("Customer");
        user7.setUsername("STARWARRIOR");

        Users user8 = new Users();
        user8.setId(8);
        user8.setFirstName("GOKU");
        user8.setLastName("SON");
        user8.setEmail("No Email");
        user8.setPhone("No Phone");
        user8.setEmployeeStatus("Customer");
        user8.setUsername("SUPERSAIYAN");

        Users user9 = new Users();
        user9.setId(9);
        user9.setFirstName("YUSUKE");
        user9.setLastName("URAMESHI");
        user9.setEmail("No Email");
        user9.setPhone("No Phone");
        user9.setEmployeeStatus("Customer");
        user9.setUsername("SPIRITDETECTIVE");

        Assert.assertEquals(user1, u.getAllUsers().get(0));
        Assert.assertEquals(user2, u.getAllUsers().get(1));
        Assert.assertEquals(user3, u.getAllUsers().get(2));
        Assert.assertEquals(user4, u.getAllUsers().get(3));
        Assert.assertEquals(user5, u.getAllUsers().get(4));
        Assert.assertEquals(user6, u.getAllUsers().get(5));
        Assert.assertEquals(user7, u.getAllUsers().get(6));
        Assert.assertEquals(user8, u.getAllUsers().get(7));
        Assert.assertEquals(user9, u.getAllUsers().get(8));
	}

	/**
	 * @author Esteban
	 * Add users by making a new User instance and providing everything except for id since it is auto generated
	 */
//	@Test
//	public void addUser() {
//		
//		u.addUser(new Users("Nill", "Bye", "No Email", "No Phone", "Customer", 5, null, "IcienceCsSool", null, null));
//		
//        Users user = new Users();
//        user.setId(24);
//        user.setFirstName("Nill");
//        user.setLastName("Bye");
//        user.setEmail("No Email");
//        user.setPhone("No Phone");
//        user.setEmployeeStatus("Customer");
//        user.setHelpedBy(5);
//        user.setUsername("IcienceCsSool");
//
//        Assert.assertEquals(user, u.getUserById(24));
//	}

	/**
	 * @author Esteban
	 * Updates a users information, need to pass every entry in the column of the database for it to work
	 * Commented out so that it won't update a user that doesn't exist/update with the same information
	 */
//	@Test
//	public void updateUser() {
//		
//		u.updateUser(new Users(24, "Nill", "Bye", "No Email", "No Phone", "Customer", 5, null, "ScienceIsNotCool", null, null));
//		
//        Users user = new Users();
//        user.setId(24);
//        user.setFirstName("Nill");
//        user.setLastName("Bye");
//        user.setEmail("No Email");
//        user.setPhone("No Phone");
//        user.setEmployeeStatus("Customer");
//        user.setHelpedBy(5);
//        user.setUsername("ScienceIsNotCool");
//
//        Assert.assertEquals(user, u.getUserById(24));
//	}

	/**
	 * @author Esteban
	 * Deletes a user by getting their id, passing that object into a Users variable, and then passes that object to the 
	 * delete method
	 * 
	 * Commented out because it will delete a user that no longer exists
	 */
//	@Test
//	public void deleteUser() {
//		
//		Users du = u.getUserById(22);
//		u.deleteUser(du);
//
//        Assert.assertNull(u.getUserById(22));
//	}

}
