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
		cal.setEventId(96);
		cal.setMemberId(134);
		cal.setDay("2019-01-25");
		cal.setTimeslot("10PM");
		cal.setType("Consultation");
		cal.setHelpedBy(128);
		
		Assert.assertEquals(cal.toString(), calendar.getCalendarEventById(96).get(0).toString()); 
		
	}
	
//	@Test
//	public void getAllCalendarEvents() {
//		
//		Calendar cal1 = new Calendar();
//		cal1.setEventId(96);
//		cal1.setMemberId(134);
//		cal1.setDay("2019-01-25");
//		cal1.setTimeslot("10PM");
//		cal1.setType("Consultation");
//		cal1.setHelpedBy(128);
//		
//		Calendar cal2 = new Calendar();
//		cal2.setEventId(95);
//		cal2.setMemberId(128);
//		cal2.setDay("2019-10-10");
//		cal2.setTimeslot("1PM");
//		cal2.setType("Advisement");
//		cal2.setHelpedBy(128);
//		
//		Calendar cal3 = new Calendar();
//		cal3.setEventId(93);
//		cal3.setMemberId(128);
//		cal3.setDay("2001-01-01");
//		cal3.setTimeslot("10PM");
//		cal3.setType("Installation");
//		cal3.setHelpedBy(128);
//		
//		Assert.assertEquals(cal1.toString(), calendar.getAllEvents().get(0).toString()); 
//		Assert.assertEquals(cal2.toString(), calendar.getAllEvents().get(1).toString()); 
//		Assert.assertEquals(cal3.toString(), calendar.getAllEvents().get(2).toString()); 
//		
//	}
	
//	@Test
//	public void addCalendarEvent() {
//		
//		Calendar cal = new Calendar();
//		cal.setMemberId(134);
//		cal.setDay("2017-08-11");
//		cal.setTimeslot("3PM");
//		cal.setType("Advisement");
//		cal.setHelpedBy(128);
//		calendar.addCalendarEvent(cal);
//		
//		Calendar cale = new Calendar();
//		cale.setEventId(97);
//		cale.setMemberId(134);
//		cale.setDay("2017-08-11");
//		cale.setTimeslot("3PM");
//		cale.setType("Advisement");
//		cale.setHelpedBy(128);
//		
//		Assert.assertEquals(cale.toString(), calendar.getCalendarEventById(97).get(0).toString());
//		
//	}
	
//	@Test
//	public void updateCalendar() {
//		
//		Calendar cale = new Calendar();
//		cale.setEventId(97);
//		cale.setMemberId(134);
//		cale.setDay("2017-08-11");
//		cale.setTimeslot("1PM");
//		cale.setType("Installation");
//		cale.setHelpedBy(128);
//		calendar.updateCalendar(cale);
//		
//		Assert.assertEquals(cale.toString(), calendar.getCalendarEventById(97).get(0).toString());
//		
//	}
	
//	@Test
//	public void deleteCalendarEvent() {
//		
//		Calendar cal = calendar.getCalendarEventById(97).get(0);
//		calendar.deleteCalendarEvent(cal);
//	
//		Assert.assertEquals(0, calendar.getCalendarEventById(97).size());
//		
//	}

}
