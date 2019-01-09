package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.RecentlyViewedDAO;
import project2.hightechindustries.dao.RecentlyViewedDAOImpl;

class RecentlyViewedTest {
	
	RecentlyViewedDAO rv = new RecentlyViewedDAOImpl();

	@Test
	public void getRecentlyViewedById() {
		
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
	public void listRecentlyViewedById() {
		
        RecentlyViewed recView = new RecentlyViewed();
		recView.setMemberId(8);
		recView.setProductId1(9);
		recView.setProductId2(9);
		recView.setProductId3(9);
		recView.setProductId4(9);
		recView.setProductId5(6);

        Assert.assertEquals(recView, rv.getAllRecentlyViewed(8));
		
	}

}
