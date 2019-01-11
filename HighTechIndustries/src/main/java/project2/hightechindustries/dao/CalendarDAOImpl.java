package project2.hightechindustries.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import project2.hightechindustries.beans.Calendar;
import project2.hightechindustries.util.HibernateUtil;

public class CalendarDAOImpl implements CalendarDAO {
	
	/**
	 * @author Esteban
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public List<Calendar> getCalendarEventById(int memberId) {
		List<Calendar> calendar = new ArrayList<>();
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			calendar = s.createQuery("from Calendar C where C.memberId = "+memberId+"").getResultList();
			tx.commit();
			s.close();
		}
		return calendar;
	}

	@Override
	public List<Calendar> getAllCalendarEvents(int memberId) {
		List<Calendar> calendar = new ArrayList<>();
		try(Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			// grabbing information from database by using createQuery with 'from RecentlyViewed' query
			calendar = s.createQuery("from Calendar C where C.memberId = "+memberId+"").getResultList();
			tx.commit();
			s.close();
		}
		return calendar;
	}

	@Override
	public void addCalendarEvent(Calendar cal) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(cal);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void updateCalendar(Calendar cal) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(cal);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteCalendarEvent(Calendar cal) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(cal);
			tx.commit();
			s.close();
		}
	}

}
