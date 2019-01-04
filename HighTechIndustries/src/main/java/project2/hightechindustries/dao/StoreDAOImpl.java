package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.util.HibernateUtil;

public class StoreDAOImpl implements StoreDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Store getStoreById(int id) {
		Store str = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			str = (Store) s.get(Store.class, id);
			tx.commit();
			s.close();
		}
		return str;
	}

	@Override
	public List<Store> getAllStore() {
		List<Store> str = new ArrayList<>();
		//use a Query to retrieve all caves
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			str = s.createQuery("from Store").getResultList();
			tx.commit();
			s.close();
		}
		return str;
	}

	@Override
	public void addStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(store);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(store);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteStore(Store store) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(store);
			tx.commit();
			s.close();
		}
	}

}
