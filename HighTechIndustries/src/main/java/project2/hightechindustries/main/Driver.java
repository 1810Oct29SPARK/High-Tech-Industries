package project2.hightechindustries.main;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.CartDAO;
import project2.hightechindustries.dao.CartDAOImpl;
import project2.hightechindustries.dao.PurchasedDAO;
import project2.hightechindustries.dao.PurchasedDAOImpl;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.RecentlyViewedDAOImpl;
import project2.hightechindustries.dao.StoreDAO;
import project2.hightechindustries.dao.StoreDAOImpl;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		
		UserDAO u = new UserDAOImpl();
		StoreDAO s = new StoreDAOImpl();
		RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();
		
		CartDAO c = new CartDAOImpl();
		PurchasedDAO p = new PurchasedDAOImpl();
//		c.deleteItem(new Cart(1, 12, 54));
		u.addUser(new Users("Bill", "Mye", null, null, "Customer", 1, null, "ShcienceGuy", null, null));
//		System.out.println(u.getUserById(1));
//		System.out.println(s.getStoreById(1));
//		List<Users> usersList = u.getAllUsers();
//		for (Users us : usersList) {
//			System.out.println(us);
//		}
//		List<Store> storeList = s.getAllStore();
//		for (Store str : storeList) {
//			System.out.println(str);
//		}
		
//		rv.addRecentlyViewed(new RecentlyViewed(3,1,2,3,4,5));
//		System.out.println(rv.getRecentlyViewedById(1));
//		List<RecentlyViewed> rvList = rv.getAllRecentlyViewed();
//		for (RecentlyViewed rvs : rvList) {
//			System.out.println(rv);
//		}
//		rv.addRecentlyViewed(new RecentlyViewed(3,11));
//		System.out.println(p.getPurchasedItemById(1));
		
	}

}
