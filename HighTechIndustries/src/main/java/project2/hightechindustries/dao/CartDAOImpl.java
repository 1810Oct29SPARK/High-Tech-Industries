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

	//The int memberId here is likely NOT the same as the memberId from Cart (which is what I eventually want it to be)
	// looks like you fixed it
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

//	this works, when someone adds a store item to cart 
//	the sequences both go, the SQL and the hibernate
	@Override
	public void addCartItem(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(c);
			tx.commit();
			s.close();
		}
	}

//  If somebody want to change the amount of robots they have in cart
//	Then we'd write this.
	
	@Override
	public void updateCart(Cart c) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			CartDAO cd = new CartDAOImpl();
			s.update(c);
			s.close();
		}
	}

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
