package project2.hightechindustries.test;

import org.junit.Assert;
import org.junit.Test;

import project2.hightechindustries.beans.Calendar;
import project2.hightechindustries.dao.CalendarDAO;
import project2.hightechindustries.dao.CalendarDAOImpl;

public class CalendarTest {
	
	CalendarDAO calendar = new CalendarDAOImpl();

	@Test
	public void getCalendarEventById() {
		
		Calendar cal = new Calendar();
		cal.setEventId(89);
		cal.setMemberId(1);
		cal.setDay("1999-09-10");
		cal.setTimeslot("10PM");
		cal.setType("Installation");
		cal.setHelpedBy(1);
		
		Assert.assertEquals(cal.toString(), calendar.getCalendarEventById(89).get(0).toString()); 
		
	}
	
	@Test
	public void getAllCalendarEvents() {
		
		Calendar cal1 = new Calendar();
		cal1.setEventId(89);
		cal1.setMemberId(1);
		cal1.setDay("1999-09-10");
		cal1.setTimeslot("10PM");
		cal1.setType("Installation");
		cal1.setHelpedBy(1);
		
		Calendar cal2 = new Calendar();
		cal2.setEventId(87);
		cal2.setMemberId(1);
		cal2.setDay("2019-08-08");
		cal2.setTimeslot("4PM");
		cal2.setType("Maintenance");
		cal2.setHelpedBy(1);
		
		Calendar cal3 = new Calendar();
		cal3.setEventId(86);
		cal3.setMemberId(2);
		cal3.setDay("2000-02-02");
		cal3.setTimeslot("1PM");
		cal3.setType("Advisement");
		cal3.setHelpedBy(82);
		
		Assert.assertEquals(cal1.toString(), calendar.getAllEvents().get(0).toString()); 
		Assert.assertEquals(cal2.toString(), calendar.getAllEvents().get(1).toString()); 
		Assert.assertEquals(cal3.toString(), calendar.getAllEvents().get(2).toString()); 
		
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
	
//	@Test
//	public void deleteCalendarEvent() {
//		
////		Calendar cal = calendar.getCalendarEventById(2).get(0);
////		calendar.deleteCalendarEvent(cal);
//	
//		Assert.assertEquals(0, calendar.getCalendarEventById(2).size());
//		
//	}

}
