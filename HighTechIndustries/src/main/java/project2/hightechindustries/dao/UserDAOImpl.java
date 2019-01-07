package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	/**
	 * @author Esteban, Sean
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	// Used to get the user back as an object by passing their id, also used to delete user
	@Override
	public Users getUserById(int id) {
		Users u = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			u = (Users) s.get(Users.class, id);
			tx.commit();
			s.close();
		}
		return u;
	}

	// Get back a list of all users, used by employees to view everyone with filters if necessary
	@Override
	public List<Users> getAllUsers() {
		// Creating a list of users to get back from database
		List<Users> users = new ArrayList<>();
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Getting info from Users table using HQL
			users = s.createQuery("from Users").getResultList();
			// Will commit  everything and shows up in database if no errors
			tx.commit();
			s.close();
		}
		// Retrieves data to be used later
		return users;
	}

	// For adding new users when they sign up
	@Override
	public void addUser(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(user);
			tx.commit();
			s.close();
		}
	}

	// When users or employees want update information
	@Override
	public void updateUser(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			s.close();
		}
	}

	// When a user deletes their account
	@Override
	public void deleteUser(Users user) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			s.close();
		}
	}

}
