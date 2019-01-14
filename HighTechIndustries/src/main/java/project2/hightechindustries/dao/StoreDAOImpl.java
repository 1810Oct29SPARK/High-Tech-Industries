package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.util.HibernateUtil;

@Service
public class StoreDAOImpl implements StoreDAO {
	
	/**
	 * @author Esteban, Sean
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	// Getting a single item in the store
	@Override
	public Store getStoreById(Integer productId) {
		Store str = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Casting to Store object to be returned and used later
			System.out.println("str before: "+str);
			str = (Store) s.get(Store.class, productId);
			System.out.println("str: "+str);
			tx.commit();
			s.close();
		}
		return str;
	}

	// Getting a list of everything in the store, can be filtered to show specific things later by front end
	@Override
	public List<Store> getAllStore() {
		List<Store> str = new ArrayList<>();
		//use a Query to retrieve all caves
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Writing a query by selecting items from Store table
			str = s.createQuery("from Store").getResultList();
			tx.commit();
			s.close();
		}
		// Returning list of items from store
		return str;
	}

	// Adding items to the store
	@Override
	public void addStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(store);
			tx.commit();
			s.close();
		}
	}

	// If new/incorrect information is in a store, it can be updated
	@Override
	public void updateStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(store);
			tx.commit();
			s.close();
		}
	}

	// Used to delet an item from the store, may be faulty/bad
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
