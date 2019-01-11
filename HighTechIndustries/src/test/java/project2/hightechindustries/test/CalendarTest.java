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
		cal.setMemberId(5);
		cal.setDay("Monday");
		cal.setTimeslot("5PM");
		cal.setType("Special Massage");
		cal.setHelpedBy(3);
		
		Assert.assertEquals(cal, calendar.getCalendarEventById(5)); //fix this to be member id, change in impl
		
	}

}
