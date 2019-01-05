package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

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

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<>();
		//use a Query to retrieve all caves
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from Users").getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	@Override
	public void addUser(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(user);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateUser(Users user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			s.close();
		}
	}

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
