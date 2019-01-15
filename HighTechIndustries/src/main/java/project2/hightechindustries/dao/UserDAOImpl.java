package project2.hightechindustries.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.util.HibernateUtil;

@Service
public class UserDAOImpl implements UserDAO {
	
	/**
	 * @author Esteban, Sean
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	/**
	 * @author SBG
	 * this is the implementation for logging into our website,
	 * you pass in username and password and a full user will be returned 
	 */
	//shits fuct boi
	//the error that gets warned the SQL Error 904 will show up for either username or password
	//it doesnt care. its just wrong no matter what.
	//god damn.
	@Override
	public Users findUser(Users name) {
		Users placeholder = null;
		String username = name.getUsername();
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			List<Users> question = s.createQuery("from Users where username='"+username+"'").getResultList();
			try {
				placeholder = question.get(0);
			} catch (Exception e) {
				System.out.println("can't find user");
			}
			tx.commit();
			s.close();
		}
		return placeholder;
	}
	
	
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


//	@Override
//	public void updateProfilePhoto(File photo, int id) {
//		try(Session s = sf.getCurrentSession()){
//			Transaction tx = s.beginTransaction();
//			Users u = (Users) s.get(Users.class, id);
//			byte[] imageInBytes = new byte[(int)photo.length()];
//			FileInputStream inputStream = new FileInputStream(photo);
//			inputStream.read(imageInBytes);
//			inputStream.close();
//			u.setPicture(imageInBytes);
//			tx.commit();
//			s.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
