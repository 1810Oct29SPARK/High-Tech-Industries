package project2.hightechindustries.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @Author (name="Sean, SBG")
 * This bean represents the Calendar Table and its columns.
 */
@Entity
@Table(name="CALENDAR")
public class Calendar {
	
	public Calendar(int eventId, int memberId, String day, String timeslot, String type, int helpedBy) {
		super();
		this.eventId = eventId;
		this.memberId = memberId;
		this.day = day;
		this.timeslot = timeslot;
		this.type = type;
		this.helpedBy = helpedBy;
	}
	
	public Calendar(int memberId, String day, String timeslot, String type, int helpedBy) {
		super();
		this.memberId = memberId;
		this.day = day;
		this.timeslot = timeslot;
		this.type = type;
		this.helpedBy = helpedBy;
	}
	
	public Calendar() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="calendarSequence")
	@SequenceGenerator(allocationSize=1, name="calendarSequence", sequenceName="SQ_CALENDAR_ID")
	@Column(name="EVENT_ID")
	int eventId;
	@Column(name="MEMBER_ID")
	int memberId;
	@Column(name="DAY")
	String day;
	@Column(name="TIMESLOT")
	String timeslot;
	@Column(name="TYPE")
	String type;
	@Column(name="HELPED_BY")
	int helpedBy;
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHelpedBy() {
		return helpedBy;
	}
	public void setHelpedBy(int helpedBy) {
		this.helpedBy = helpedBy;
	}
	@Override
	public String toString() {
		return "Calendar [eventId=" + eventId + ", memberId=" + memberId + ", day=" + day + ", timeslot=" + timeslot
				+ ", type=" + type + ", helpedBy=" + helpedBy + "]";
	}

}
