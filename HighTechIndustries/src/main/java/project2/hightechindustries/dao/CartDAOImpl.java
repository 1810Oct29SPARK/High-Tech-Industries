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

	//The memberId and productId here may or may NOT be the ones from Cart, so work still needs to be done here
	@Override
	public Cart getCartById(int memberId, int productId) {
		Cart item = null;
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			item = (Cart) s.get(Cart.class, productId);
			tx.commit();
			s.close();
		}
		return item;
	}

	//The int memberId here is likely NOT the same as the memberId from Cart (which is what I eventually want it to be)
	@Override
	public List<Cart> getAllCartItemsById(int memberId) {
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

//	@Override
//	public void updateCart(Cart c) {
//		try (Session s = sf.getCurrentSession()){
//			Transaction tx = s.beginTransaction();
//			s.update(c);
//			s.close();
//		}
//	}

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
