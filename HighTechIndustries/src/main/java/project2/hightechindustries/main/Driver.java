package project2.hightechindustries.main;

import java.util.List;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.RecentlyViewedDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		
<<<<<<< HEAD
//		Cart c = new Cart(2, 2, 10);
//		CartDAO cd = new CartDAOImpl();
//		cd.addOrUpdateCartItem(c);
		
		RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();
		
		rv.newRecentlyViewed(new RecentlyViewed(1));
		
//		System.out.println(rv.getRecentlyViewedById(8));
//
//		List<RecentlyViewed> recViewedL = rv.getAllRecentlyViewed(8);
//		for (RecentlyViewed rvl : recViewedL) {
//			System.out.println(rvl);
//		}
=======
		Purchased p = new Purchased(1, 6, 5);
		PurchasedDAO pd = new PurchasedDAOImpl();
		pd.addOrUpdatePurchasedItem(p);
		
		
>>>>>>> bcf5bf2d9602544d3cfe245a0de6e9ed408c9897
		
	}

}
