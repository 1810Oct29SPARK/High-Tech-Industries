package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

	/**
	 * @author (name=Sean)
	 */
	public void addOrUpdateCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Query copyCheck = s.createQuery("select C.productId from Cart C where C.productId ="+ c.getProductId() +"and C.memberId ="+ c.getMemberId()+"");
			if (copyCheck == null) {
				s.persist(c);
			} else {
				s.update(c);
			}
			tx.commit();
			s.close();
			
			
		}
	}
	
	/**
	 * @author (name=Sean)
	 */
	
	public void deleteOrUpdateCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			Query copyCheck = s.createQuery("select C.productId from Cart C where C.productId ="+ c.getProductId()
					+ "and C.memberId ="+ c.getMemberId()
					+ "and C.quantity = 1");
			if (copyCheck == null) {
				s.update(c);
			} else {
				s.delete(c);
			}
			tx.commit();
			s.close();
			
			
		}
	}
	
}