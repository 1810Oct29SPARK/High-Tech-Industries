package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.RecentlyViewed;
import project2.hightechindustries.beans.Users;
import project2.hightechindustries.util.HibernateUtil;

public class RecentlyViewedDAOImpl implements RecentlyViewedDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public RecentlyViewed getRecentlyViewedById(int id) {
		RecentlyViewed rv = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			rv = (RecentlyViewed) s.get(RecentlyViewed.class, id);
			tx.commit();
			s.close();
		}
		return rv;
	}

	@Override
	public List<RecentlyViewed> getAllRecentlyViewed() {
		List<RecentlyViewed> recViewed = new ArrayList<>();
		//use a Query to retrieve all caves
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			recViewed = s.createQuery("from RecentlyViewed").getResultList();
			tx.commit();
			s.close();
		}
		return recViewed;
	}

	@Override
	public void addRecentlyViewed(RecentlyViewed rv) {
		try(SessionFactory sf = HibernateUtil.getSessionFactory()) {
			Session s = sf.getCurrentSession();
			Transaction tx = s.beginTransaction();
			RecentlyViewed ou = new RecentlyViewed();
			rv.setProductId5(ou.getProductId5());
			rv.setProductId4(ou.getProductId4());
			rv.setProductId3(ou.getProductId3());
			rv.setProductId2(ou.getProductId2());
			s.persist(rv);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateRecentlyViewed(RecentlyViewed rv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecentlyViewed(RecentlyViewed rv) {
		// TODO Auto-generated method stub
		
	}

}
