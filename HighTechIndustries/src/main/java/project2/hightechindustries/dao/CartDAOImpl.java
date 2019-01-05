package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.util.HibernateUtil;

public class CartDAOImpl implements CartDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Cart getCartById(int id) {
		Cart item = null;
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			item = (Cart) s.get(Cart.class, id);
			tx.commit();
			s.close();
		}
		return item;
	}

	@Override
	public List<Cart> getAllCartItems() {
		List<Cart> items = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			items = s.createQuery("from Cart").getResultList();
			tx.commit();
			s.close();
		}
		return items;
	}

	@Override
	public void addCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(c);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateCart(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.update(c);
			s.close();
		}
	}

	@Override
	public void deleteItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(c);
			s.close();
		}
	}

}
