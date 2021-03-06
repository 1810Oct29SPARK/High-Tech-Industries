package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import project2.hightechindustries.beans.Cart;
import project2.hightechindustries.util.HibernateUtil;

@Service
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
	 * Here is a method defined for deleting Cart Items.
	 * Unlike adding/updating, deleting is an all or nothing deal.
	 * You can either leave it on your cart and just not buy all of
	 *  them, or you can remove the entry, which removes them all.
	 * It could serve in discouraging customers from deleting items 
	 *  from their cart if they do have more than one, but then again,
	 *  we really don't want customers to remove items from their cart,
	 *  but to be fair, it should be allowed.
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