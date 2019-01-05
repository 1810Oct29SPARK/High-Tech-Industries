package project2.hightechindustries.dao;

import java.util.List;

import project2.hightechindustries.beans.Calendar;

public interface CalendarDAO {
	
	public Calendar getCalendarEventById(int id);
	public List<Calendar> getAllCalendarEvents();
	public void addCalendarEvent(Calendar cal);
	public void updateCalendar(Calendar cal);
	public void deleteCalendarEvent(Calendar cal);

}
