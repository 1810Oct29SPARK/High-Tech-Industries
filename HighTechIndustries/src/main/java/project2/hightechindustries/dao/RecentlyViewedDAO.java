package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.RecentlyViewed;

public interface RecentlyViewedDAO {

	/**
	 * @author (name=Sean)
	 * This method is here so members can view one particular item from their Recently Viewed List
	 *   Ex: Their most recently viewed, the item they viewed three items ago, etc.
	 */
	public RecentlyViewed getRecentlyViewedById(int id);
	
	/**
	 * @author (name=Sean)
	 * This method is here so members can view their entire Recently Viewed List
	 * The list consists of the five most recently viewed items by the member
	 */
	public List<RecentlyViewed> getAllRecentlyViewed();
	
	/**
	 * @author (name=Sean)
	 * This method is here so when a visitor signs up and becomes a member,
	 *   that member will have a new recently viewed list,
	 *     which at the time of its creation will consist of five null objects, 
	 *     but will be replaced by recently viewed items as the member views items.
	 */
	public void newRecentlyViewed(RecentlyViewed rv);
	
	/**
	 * @author (name=Sean)
	 * This method is here so that when a member views a new item that item will be added to the list
	 *  of recently viewed items.
	 */
	public void addRecentlyViewed(RecentlyViewed rv);
	
	/**
	 * @author (name=Sean)
	 * This method is here because the recently viewed list only holds the five most recently viewed items,
	 *  so when the member views a sixth item or beyond, the item least recently viewed on the Recently Viewed
	 *  list gets removed from the list.
	 * @param rv
	 */
	public void deleteRecentlyViewed(RecentlyViewed rv);

}
