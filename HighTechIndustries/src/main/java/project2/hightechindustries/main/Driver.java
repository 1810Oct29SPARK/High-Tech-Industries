package project2.hightechindustries.main;


import java.util.List;

import project2.hightechindustries.beans.Purchased;
import project2.hightechindustries.beans.RecentlyViewed;
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
<<<<<<< HEAD
		p.addPurchased(new Purchased(1,3,13));
		p.addPurchased(new Purchased(1,6,23));
		List<Purchased> purchasedList = p.getPurchasedItemsByProductId(3);
		for (Purchased pc : purchasedList) {
			System.out.println(pc);
		}
=======
//		Users ou = u.getUserById(10);
//		u.deleteUser(ou);
//		c.deleteItem(new Cart(1, 12, 54));
//		UserDAO u = new UserDAOImpl();
//		StoreDAO s = new StoreDAOImpl();
//		RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();
//		CartDAO c = new CartDAOImpl();
//		p.addPurchased(new Purchased(1,3,13));
//		p.addPurchased(new Purchased(1,6,23));
//		List<Purchased> purchasedList = p.getPurchasedItemsByProductId(3);
//		for (Purchased pc : purchasedList) {
//			System.out.println(pc);
//		}
>>>>>>> 539d79eb2a794358a4360cfd14783e52353715ec
//		System.out.println("owned by mario");
//		List<Purchased> ownedList = p.getPurchasedItemsByMemberId(1);
//		for (Purchased pc : ownedList) {
//			System.out.println(pc);
//		}
//		System.out.println("owned by mario");
//		PurchasedDAO pu = new PurchasedDAOImpl();
//		p.addPurchased(new Purchased(1,3,13));
//		p.addPurchased(new Purchased(1,6,23));
//		p.deletePurchased(new Purchased(5));
//		List<Purchased> purchasedList = p.getPurchasedItems(3);
//		for (Purchased pc : purchasedList) {
//			System.out.println(pc);
//		}
//		p.addPurchased(new Purchased(1,3,13));
//		p.addPurchased(new Purchased(1,6,23));
//		List<Purchased> purchasedList = p.getPurchasedItemsByProductId(3);
//		for (Purchased pc : purchasedList) {
//			System.out.println(pc);
//		}
//		System.out.println("owned by mario");
//		List<Purchased> ownedList = p.getPurchasedItemsByMemberId(1);
//		for (Purchased pc : ownedList) {
//			System.out.println(pc);
//		}
//		System.out.println("owned by mario");
<<<<<<< HEAD
=======
//		p.addPurchased(new Purchased(1,3,13));
//		p.addPurchased(new Purchased(1,6,23));
//		List<Purchased> purchasedList = p.getPurchasedItemsByProductId(3);
//		for (Purchased pc : purchasedList) {
//			System.out.println(pc);
//		}
//		System.out.println("owned by mario");
//		List<Purchased> ownedList = p.getPurchasedItemsByMemberId(1);
//		for (Purchased pc : ownedList) {
//			System.out.println(pc);
//		}
//		System.out.println("owned by mario");
>>>>>>> 539d79eb2a794358a4360cfd14783e52353715ec
//		c.getAllCartItemsById(2);
//		c.deleteItem(new Cart(18));
		
//		List<Cart> cartList = c.getAllCartItemsById(2);
//		for (Cart ca : cartList) {
//			System.out.println(ca);
//		}
		
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
<<<<<<< HEAD
//		rv.newRecentlyViewed(new RecentlyViewed(8));
//		rv.addRecentlyViewed(new RecentlyViewed(8,6));
//		List<RecentlyViewed> rvList = rv.getAllRecentlyViewed();
//		for (RecentlyViewed rvs : rvList) {
//			System.out.println(rv);
//		}
//		rv.newRecentlyViewed(new RecentlyViewed(5));
//		rv.addRecentlyViewed(new RecentlyViewed(5,6));
=======
		List<RecentlyViewed> rvList = rv.getAllRecentlyViewed(8);
		for (RecentlyViewed rvs : rvList) {
			System.out.println(rvs);
		}
//		rv.addRecentlyViewed(new RecentlyViewed(7, 12));
>>>>>>> 539d79eb2a794358a4360cfd14783e52353715ec
//		System.out.println(p.getPurchasedItemById(1));
	}

}
