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

	@PostMapping(value = "/addEvent")
	public ResponseEntity<Calendar> addEvent(@RequestParam int memberId, @RequestParam String day,
			@RequestParam String timeslot, @RequestParam String type, @RequestParam int helpedBy) {
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

//	@GetMapping(value = "/allEvents")
//	public ResponseEntity<List<Calendar>> getAllEvents(@RequestPara)

}
