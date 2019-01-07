package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.util.HibernateUtil;

public class CartDAOImpl implements CartDAO {
	
	/**
	 * @author Esteban
	 */
	
	// Using SessionFactory to create a new session
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	// Getting back a list of items in the users cart
	@Override
	public List<Cart> getAllCartItemsById(int memberId) {
		List<Cart> items = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			items = s.createQuery("from Cart C where C.memberId ="+memberId+"").getResultList();
			tx.commit();
			s.close();
		}
		return items;
	}

//	Add an item into the cart
	@Override
	public void addCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(c);
			tx.commit();
			s.close();
		}
	}

//  This still needs to be done by Stewart
	@Override
	public void updateCart(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			CartDAO cd = new CartDAOImpl();
			s.update(c);
			s.close();
		}
	}

	// Detel items from the cart
	@Override
	public void deleteItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(c);
			tx.commit();
			s.close();
		}
	}

}
