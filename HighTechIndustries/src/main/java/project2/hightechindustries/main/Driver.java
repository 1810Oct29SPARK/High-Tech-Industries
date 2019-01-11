package project2.hightechindustries.main;

import project2.hightechindustries.beans.Calendar;
import project2.hightechindustries.dao.CalendarDAO;
import project2.hightechindustries.dao.CalendarDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		
//		Cart c = new Cart(2, 2, 10);
//		CartDAO cd = new CartDAOImpl();
//		cd.addOrUpdateCartItem(c);
		
//		RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();
//		
//		rv.newRecentlyViewed(new RecentlyViewed(1));
		
		CalendarDAO calendar = new CalendarDAOImpl();
		calendar.addCalendarEvent(new Calendar(5, "Monday", "5PM", "Special Massage", 3));
		
//		System.out.println(rv.getRecentlyViewedById(8));
//
//		List<RecentlyViewed> recViewedL = rv.getAllRecentlyViewed(8);
//		for (RecentlyViewed rvl : recViewedL) {
//			System.out.println(rvl);
//		}
//		Purchased p = new Purchased(1, 6, 5);
//		PurchasedDAO pd = new PurchasedDAOImpl();
//		pd.addOrUpdatePurchasedItem(p);
		
		
		
	}

}
