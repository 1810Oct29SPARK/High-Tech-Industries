package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Calendar;

public interface CalendarDAO {
	
	/**
	 * Naming methods to be defined in the DAO Implementations
	 * Here we have named a method for getting all events by event Id and another by member Id,
	 *  a method for getting all events in the calendar, a method for adding events to the 
	 *  calendar, a method for updating events already in the calendar, and a method for removing
	 *  events from the calendar. 
	 */
	
	public List<Calendar> getCalendarEventById(int eventId);
	public List<Calendar> getAllCalendarEvents(int memberId);
	public List<Calendar> getAllEvents();
	public void addCalendarEvent(Calendar cal);
	public void updateCalendar(Calendar cal);
	public void deleteCalendarEvent(Calendar cal);

}
