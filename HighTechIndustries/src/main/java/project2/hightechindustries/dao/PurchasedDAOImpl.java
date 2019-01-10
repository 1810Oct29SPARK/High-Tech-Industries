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

/**
 * @Author (name="Sean,SBG")
 * the PurchasedDAOImpl will be called only once either
 * an employee or customer has logged in
 **/
public class PurchasedDAOImpl implements PurchasedDAO {

	private SessionFactory sf = HibernateUtil.getSessionFactory();
	
	
	/**
	 * @Author (name="Sean,SBG")
	 * the getPurchasedItemsByMember method will return a list of all those
	 * products owned by a customer.
	 * this will be for showing a customer what they have.
	 * employees will also have this ability
	 **/
	@Override
	public List<Purchased> getPurchasedItemsByMemberId(int memberId) {
		List <Purchased> owned = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			owned = s.createQuery("from Purchased P where P.memberId = "+memberId+"").getResultList();
			tx.commit();
			s.close();
		}
		return owned;
	}
	/**
	 * @Author (name="Sean,SBG")
	 * the getPurchasedItemsByProductId method will
	 * return a list of all the purchased units of the specified id
	 * this is in case we need to issue a recall on a particular unit
	 * or notify owners of potential issues 
	 * */
	@Override
	public List<Purchased> getPurchasedItemsByProductId(int productId) {
		List <Purchased> owners = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			owners = s.createQuery("from Purchased P where P.productId = "+productId+"").getResultList();
			tx.commit();
			s.close();
		}
		return owners;
	}
	/** 
	 * @Author (name="Sean,SBG")
	 * the getAllPurchased method will return a list of all the
	 * owned robots that anyone has purchased from our company
	 * this is for spying purposes.
	 * A Big Brother Type deal
	 * 
	 * */
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

	/**
	 * @Author (name="Sean,SBG")
	 * the addPurchased method will be called when a transaction is successfully made.
	 * things within the cart will be moved to the purchased table
	 * this method will only be called from the cart, so there is no
	 * need to check if the current object is in the cart
	 * 
	 **/
	
	
	public void addOrUpdatePurchasedItem(Purchased p) {
		Purchased updated = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			Query<Purchased> copyCheck = s.createQuery("from Purchased P where P.productId =" + p.getProductId() + "and P.memberId =" + p.getMemberId() + "");
			List<Purchased> item = copyCheck.list();
			if (item.isEmpty()) {
				// just add a new cart item
				s.persist(p);
			} else {
				// if in DB then get constructed version of query
				Purchased result = item.get(0);
				int priorQuantity = result.getQuantity();
				int requestedQuantity = p.getQuantity();
				int newQuantity = priorQuantity + requestedQuantity;
				updated = new Purchased(p.getMemberId(), p.getProductId(), newQuantity);
				s.persist(updated);
				s.delete(result);
			}
			tx.commit();
			s.close();

		}
	}

	/**
	 * @Author (name="Sean,SBG")
	 * the deletePurchased method will go ahead and remove an entry from the DB
	 * this will be called only be employees
	 * this would happen if the customer returned the product or it can be confirmed
	 * no longer existent
	 * 
	 * 
	 **/
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
