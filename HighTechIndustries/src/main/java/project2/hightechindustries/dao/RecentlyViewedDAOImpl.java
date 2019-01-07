package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.RecentlyViewed;
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
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			RecentlyViewedDAO rvt = new RecentlyViewedDAOImpl();
			RecentlyViewed ou = rvt.getRecentlyViewedById(rv.getMemberId());
			
			if (ou.getProductId1() == null) {
				ou.setProductId1(rv.getProductId1());
			}
			else if (ou.getProductId2() == null) {
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			else if (ou.getProductId3() == null) {
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			
			else if (ou.getProductId4() == null) {
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			else if (ou.getProductId5() == null) {
				ou.setProductId5(ou.getProductId4());
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			else {
				ou.setProductId5(ou.getProductId4());
				ou.setProductId4(ou.getProductId3());
				ou.setProductId3(ou.getProductId2());
				ou.setProductId2(ou.getProductId1());
				ou.setProductId1(rv.getProductId1());
			}
			s.saveOrUpdate(ou);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteRecentlyViewed(RecentlyViewed rv) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(rv);
			tx.commit();
			s.close();
		}
	}

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
