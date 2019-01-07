package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.RecentlyViewed;

public interface RecentlyViewedDAO {
	
	public RecentlyViewed getRecentlyViewedById(int id);
	public List<RecentlyViewed> getAllRecentlyViewed();
	public void newRecentlyViewed(RecentlyViewed rv);
	public void addRecentlyViewed(RecentlyViewed rv);
	public void deleteRecentlyViewed(RecentlyViewed rv);

}
