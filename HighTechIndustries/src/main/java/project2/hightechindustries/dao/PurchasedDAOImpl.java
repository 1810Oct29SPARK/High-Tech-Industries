package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Purchased;
import project2.hightechindustries.util.HibernateUtil;

public class PurchasedDAOImpl implements PurchasedDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public Purchased getPurchasedItemById(int id) {
		Purchased item = null;
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			item = (Purchased) s.get(Purchased.class, id);
			tx.commit();
			s.close();
		}
		return item;
	}

	@Override
	public List<Purchased> getAllPurchased() {
		List<Purchased> items = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			items = s.createQuery("from Purchased").getResultList();
			tx.commit();
			s.close();
		}
		return items;
	}

	@Override
	public void addPurchased(Purchased p) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(p);
			tx.commit();
			s.close();
		}
	}

//	@Override
//	public void updatePurchased(Purchased p) {
//		try (Session s = sf.getCurrentSession()){
//			Transaction tx = s.beginTransaction();
//			s.update(p);
//			tx.commit();
//			s.close();
//		}
//	}

	@Override
	public void deletePurchased(Purchased p) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(p);
			tx.commit();
			s.close();
		}
	}

}
