package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import project2.hightechindustries.beans.Calendar;
import project2.hightechindustries.dao.CalendarDAO;
import project2.hightechindustries.dao.CalendarDAOImpl;

class CalendarTest {
	
	CalendarDAO calendar = new CalendarDAOImpl();

	@Test
	public void getCalendarEventById() {
		
		Calendar cal = new Calendar();
		cal.setEventId(21);
		cal.setMemberId(5);
		cal.setDay("Monday");
		cal.setTimeslot("5PM");
		cal.setType("Special Massage");
		cal.setHelpedBy(3);
		
		Assert.assertEquals(cal.toString(), calendar.getCalendarEventById(5).get(0).toString()); 
		
	}
	
	@Test
	public void getAllCalendarEvents() {
		
		Calendar cal1 = new Calendar();
		cal1.setEventId(21);
		cal1.setMemberId(5);
		cal1.setDay("Monday");
		cal1.setTimeslot("5PM");
		cal1.setType("Special Massage");
		cal1.setHelpedBy(3);
		
		Calendar cal2 = new Calendar();
		cal2.setEventId(1);
		cal2.setMemberId(5);
		cal2.setDay("Monday");
		cal2.setTimeslot("5PM");
		cal2.setType("Special Massage");
		cal2.setHelpedBy(3);
		
		Assert.assertEquals(cal1.toString(), calendar.getCalendarEventById(5).get(0).toString()); 
		Assert.assertEquals(cal2.toString(), calendar.getCalendarEventById(5).get(1).toString()); 
		
	}
	
//	@Test
//	public void addCalendarEvent() {
//		
//		Calendar cal = new Calendar();
//		cal.setMemberId(2);
//		cal.setDay("Monday");
//		cal.setTimeslot("3PM");
//		cal.setType("Regular Massage");
//		cal.setHelpedBy(6);
////		calendar.addCalendarEvent(cal);
//		
//		Calendar cale = new Calendar();
//		cale.setEventId(22);
//		cale.setMemberId(2);
//		cale.setDay("Monday");
//		cale.setTimeslot("3PM");
//		cale.setType("Regular Massage");
//		cale.setHelpedBy(6);
//		
//		Assert.assertEquals(cale.toString(), calendar.getCalendarEventById(2).get(0).toString());
//		
//	}
	
//	@Test
//	public void updateCalendar() {
//		
//		Calendar cale = new Calendar();
//		cale.setEventId(22);
//		cale.setMemberId(2);
//		cale.setDay("Monday");
//		cale.setTimeslot("3PM");
//		cale.setType("Special Massage");
//		cale.setHelpedBy(6);
//		calendar.updateCalendar(cale);
//		
//		Assert.assertEquals(cale.toString(), calendar.getCalendarEventById(2).get(0).toString());
//		
//	}
	
	@Test
	public void deleteCalendarEvent() {
		
//		Calendar cal = calendar.getCalendarEventById(2).get(0);
//		calendar.deleteCalendarEvent(cal);
	
		Assert.assertEquals(0, calendar.getCalendarEventById(2).size());
		
	}

}
