package project2.hightechindustries.main;

import java.util.List;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.StoreDAO;
import project2.hightechindustries.dao.StoreDAOImpl;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		UserDAO u = new UserDAOImpl();
		StoreDAO s = new StoreDAOImpl();
//		System.out.println(u.getUserById(1));
//		System.out.println(s.getStoreById(1));
//		List<Users> usersList = u.getAllUsers();
//		for (Users us : usersList) {
//			System.out.println(us);
//		}
		List<Store> storeList = s.getAllStore();
		for (Store str : storeList) {
			System.out.println(str);
		}
		
	}

}
