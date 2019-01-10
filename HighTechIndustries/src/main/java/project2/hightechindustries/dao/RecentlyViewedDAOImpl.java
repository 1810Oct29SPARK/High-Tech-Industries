package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.util.HibernateUtil;

public class RecentlyViewedDAOImpl implements RecentlyViewedDAO {
	
	/**
	 * @author Esteban
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	// Used with add method to get the members Id
	@Override
	public RecentlyViewed getRecentlyViewedById(int id) {
		RecentlyViewed rv = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Storing recently viewed item in rv, casting to RecentlyViewed for return statement
			rv = (RecentlyViewed) s.get(RecentlyViewed.class, id);
			tx.commit();
			s.close();
		}
		return rv;
	}

	// Getting list of items for customers recently viewed
	@Override
	public List<RecentlyViewed> getAllRecentlyViewed(int memberId) {
		List<RecentlyViewed> recViewed = new ArrayList<>();
		try(Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			// grabbing information from database by using createQuery with 'from RecentlyViewed' query
			recViewed = s.createQuery("from RecentlyViewed RV where RV.memberId = "+memberId+"").getResultList();
			tx.commit();
			s.close();
		}
		return recViewed;
	}
	
	/**
	 * @author Esteban, Stewart, Jeremy
	 */

	// Adding item to database with 5 items, creating a new session within a session
	@Override
	public void addRecentlyViewed(RecentlyViewed rv) {
		try(SessionFactory sfn = HibernateUtil.getSessionFactory()) {
			// Creating a new session to get info from database
			Session sn = sfn.openSession();
			// Creating new transaction
			Transaction txn = sn.beginTransaction();
			// Creating an instance of RecentlyViewed to get items from database by members id
			RecentlyViewedDAO rvt = new RecentlyViewedDAOImpl();
			RecentlyViewed ou = rvt.getRecentlyViewedById(rv.getMemberId());
			
			// If there is no item in the first position in the database, add the recently viewed item in position 1
			if (ou.getProductId1() == null) {
				ou.setProductId1(rv.getProductId1());
			}
			
			// If there is an item in the first position but not in the second, move item from position 1 to 2 and new
			// recently viewed item into position 1
			else if (ou.getProductId2() == null) {
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			
			// If there are items in positions 1 and 2 but not in 3, then shift items from 1 and 2 into 2 and 3 respectively
			// and add new item into position 1
			else if (ou.getProductId3() == null) {
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			
			// If there are items in first 3 positions, shift them over by one and add new item into position 1
			else if (ou.getProductId4() == null) {
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			
			// If there are items in all the positions except for the 5th position, then shift over everything by one
			// and add new item into the first position, filling up the number of recently viewed items for that user
			// in the database
			else if (ou.getProductId5() == null) {
				ou.setProductId5(ou.getProductId4());
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			
			// If there are items in all the positions, shift everything over by one, dropping the item in position 5 and
			// replacing it with the item in position 4, and add new item into position 1
			else {
				ou.setProductId5(ou.getProductId4());
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			// Using saveOrUpdate to add a new item if there is nothing in the database (new user where they havn't seen 
			// anything yet) or updating their info if there is already at least one item in their recently viewed
			sn.saveOrUpdate(ou);
			txn.commit();
			sn.close();
		}
	}

	// If a user 'deletes' their account, we will delete their info from the recently viewed table and start fresh
	@Override
	public void deleteRecentlyViewed(RecentlyViewed rv) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(rv);
			tx.commit();
			s.close();
		}
	}

	// When a user creates an account, we will add a new entry in the recently viewed table with null values because
	// otherwise, we can't add or update info into their recently viewed table since their isn't an entry for that user
	@Override
	public void newRecentlyViewed(RecentlyViewed rv) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(rv);
			tx.commit();
			s.close();
		}
	}

}
