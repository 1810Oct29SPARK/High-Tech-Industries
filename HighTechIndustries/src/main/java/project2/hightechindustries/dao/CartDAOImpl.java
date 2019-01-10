package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.beans.Purchased;
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
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			items = s.createQuery("from Cart C where C.memberId =" + memberId + "").getResultList();
			tx.commit();
			s.close();
		}
		return items;
	}

	/**
	 * @author (name=Stewart, Sean) Planning for Adding a Cart Item / Updating its
	 *         Quantity:
	 * 
	 *         We need to search for an existing entry that matches the member's
	 *         memberId and requested productId if there is none, a new entry is
	 *         created, matching the memberId, productId, and quantity if there is
	 *         one: a new entry is created, matching the memberId, productId, and
	 *         the sum of the two quantities Then the pre-existing entry is deleted
	 */
	public void addOrUpdateCartItem(Cart c) {
		Cart updated = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			Query<Cart> copyCheck = s.createQuery("from Cart C where C.productId =" + c.getProductId() + "and C.memberId =" + c.getMemberId() + "");
			List<Cart> item = copyCheck.list();
			if (item.isEmpty()) {
				// just add a new cart item
				s.persist(c);
			} else {
				// if in DB then get constructed version of query
				Cart result = item.get(0);
				int priorQuantity = result.getQuantity();
				int requestedQuantity = c.getQuantity();
				int newQuantity = priorQuantity + requestedQuantity;
				updated = new Cart(c.getMemberId(), c.getProductId(), newQuantity);
				s.persist(updated);
				s.delete(result);
			}
			tx.commit();
			s.close();

		}
	}

	/**
	 * @author (name=Sean, Stewart)
	 * Grunt, Grunt, Good Job!
	 * Shark Bait, Ooh ha ha!
	 */

	@Override
	public void deleteCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(c);
			tx.commit();
			s.close();
		}
	}

}