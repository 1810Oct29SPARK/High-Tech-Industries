package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Calendar;

public interface CalendarDAO {
	
	public List<Calendar> getCalendarEventById(int eventId);
	public List<Calendar> getAllCalendarEvents(int memberId);
	public void addCalendarEvent(Calendar cal);
	public void updateCalendar(Calendar cal);
	public void deleteCalendarEvent(Calendar cal);

}
