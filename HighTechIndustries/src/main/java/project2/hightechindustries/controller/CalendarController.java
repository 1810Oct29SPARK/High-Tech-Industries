package project2.hightechindustries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project2.hightechindustries.beans.Calendar;
import project2.hightechindustries.dao.CalendarDAO;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {
	
	/**
	 * The Calendar Controller is here to deliver our information gathered from the back
	 *  to the front.
	 * We have a method for getting individual events by their id, getting a full list
	 *  of events for a particular member, a method enabling employees to add events for
	 *  their members, and a method enabling employees to pull up a list of all scheduled
	 *  events.
	 */

	@Autowired
	private CalendarDAO cal;

	@GetMapping(value = "/{eventId}")
	public ResponseEntity<Calendar> getEventById(@PathVariable int eventId) {
		Calendar c = cal.getCalendarEventById(eventId).get(0);
		if (c != null) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/memberEvents/{memberId}")
	public ResponseEntity<List<Calendar>> getAllEvents(@PathVariable int memberId) {
		List<Calendar> c = cal.getAllCalendarEvents(memberId);
		if (c.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/addEvent/{memberId}/{type}/{day}/{timeslot}/{helpedBy}")
	public ResponseEntity<Calendar> addEvent(@PathVariable int memberId, @PathVariable String day,
			@PathVariable String timeslot, @PathVariable String type, @PathVariable int helpedBy) {
		try {
			cal.addCalendarEvent(new Calendar(memberId, day, timeslot, type, helpedBy));
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/allEvents")
	public ResponseEntity<List<Calendar>> getAllEvets() {
		List<Calendar> c = cal.getAllEvents();
		if (c.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/deleteEvent{eventId}")
	public ResponseEntity<Calendar> deleteEventById(@PathVariable int eventId) {
		Calendar c = cal.getCalendarEventById(eventId).get(0);
		try {
			cal.deleteCalendarEvent(c);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

//	@GetMapping(value = "/allEvents")
//	public ResponseEntity<List<Calendar>> getAllEvents(@RequestPara)

}
