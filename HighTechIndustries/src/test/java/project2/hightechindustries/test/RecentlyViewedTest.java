package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.Test;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.RecentlyViewedDAOImpl;

class RecentlyViewedTest {
	
	RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();

	@Test
	public void getRecentlyViewedByIdTest() {
		
		RecentlyViewed recViewed = new RecentlyViewed();
		recViewed.setMemberId(8);
		recViewed.setProductId1(9);
		recViewed.setProductId2(9);
		recViewed.setProductId3(9);
		recViewed.setProductId4(9);
		recViewed.setProductId5(6);

        Assert.assertEquals(recViewed.getMemberId(), rv.getRecentlyViewedById(8).getMemberId());
        Assert.assertEquals(recViewed.getProductId1(), rv.getRecentlyViewedById(8).getProductId1());
        Assert.assertEquals(recViewed.getProductId2(), rv.getRecentlyViewedById(8).getProductId2());
        Assert.assertEquals(recViewed.getProductId3(), rv.getRecentlyViewedById(8).getProductId3());
        Assert.assertEquals(recViewed.getProductId4(), rv.getRecentlyViewedById(8).getProductId4());
        Assert.assertEquals(recViewed.getProductId5(), rv.getRecentlyViewedById(8).getProductId5());
	}
	
	@Test
	public void listRecentlyViewedByIdTest() {
		
        RecentlyViewed recView = new RecentlyViewed();
		recView.setMemberId(8);
		recView.setProductId1(9);
		recView.setProductId2(9);
		recView.setProductId3(9);
		recView.setProductId4(9);
		recView.setProductId5(6);

        Assert.assertEquals(recView.getMemberId(), rv.getRecentlyViewedById(8).getMemberId());
        Assert.assertEquals(recView.getProductId1(), rv.getRecentlyViewedById(8).getProductId1());
        Assert.assertEquals(recView.getProductId2(), rv.getRecentlyViewedById(8).getProductId2());
        Assert.assertEquals(recView.getProductId3(), rv.getRecentlyViewedById(8).getProductId3());
        Assert.assertEquals(recView.getProductId4(), rv.getRecentlyViewedById(8).getProductId4());
        Assert.assertEquals(recView.getProductId5(), rv.getRecentlyViewedById(8).getProductId5());
		
	}
	
//	@Test
//	public void newRecentlyVIewedTest() {
//		
//      RecentlyViewed recView = new RecentlyViewed();
//		recView.setMemberId(3);
//		
////		rv.newRecentlyViewed(new RecentlyViewed(3));
//		
//		Assert.assertEquals(recView.getMemberId(), rv.getRecentlyViewedById(3).getMemberId());
//		
//	}
	
//	@Test
//	public void addRecentlyViewedTest() {
//		
//        RecentlyViewed recView = new RecentlyViewed();
//		recView.setMemberId(3);
//		recView.setProductId1(2);
//		recView.setProductId2(6);
//		
//		//cannot run addRecentlyViewed and then list because it will crash
////		rv.addRecentlyViewed(new RecentlyViewed(3, 2));
//
//        Assert.assertEquals(recView.getMemberId(), rv.getRecentlyViewedById(3).getMemberId());
//        Assert.assertEquals(recView.getProductId1(), rv.getRecentlyViewedById(3).getProductId1());
//        Assert.assertEquals(recView.getProductId2(), rv.getRecentlyViewedById(3).getProductId2());
//		
//	}
	
	@Test
	public void deleteRecentlyViewedTest() {
		
		RecentlyViewed drv = rv.getRecentlyViewedById(3);
		rv.deleteRecentlyViewed(drv);
		
		Assert.assertNull(rv.getRecentlyViewedById(3));
		
	}

}
