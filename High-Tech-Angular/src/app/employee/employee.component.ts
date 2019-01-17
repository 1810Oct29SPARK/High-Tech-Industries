import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { CalendarComponent } from '../calendar/calendar.component';
import { NgbDateStruct, NgbCalendar } from '@ng-bootstrap/ng-bootstrap';

// Jeremy

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public configService: ConfigService, private calendar: NgbCalendar) { }

  model: NgbDateStruct;
  date: { year: number, month: number };
  IDs: any;
  allEvents: any;
  members: string[];
  events: string[];

  showMembers: boolean = true;

  submitted = false;


  selectToday() {
    this.model = this.calendar.getToday();
  }

  deleteEvent(value){
    this.configService.deleteCalendarEvent(value).subscribe( (data) => {
    })
    location.reload();
  }

  getEvents(){
    this.configService.getAllEvents().subscribe( (data) => {
      this.allEvents = data;
      for(let x = 0; x < data.length; ++x ){
      this.configService.getUser(data[x].memberId).subscribe( (e) => {
        this.allEvents[x].memberId = e.firstName + " " + e.lastName;
      })
    }
    })
  }


  onSubmit() {
    this.submitted = true;
    console.log("hello");
  }

  ngOnInit() {
    this.getMemberList();
    this.getCalendarEvents();
    this.getEvents();
  }

  getMemberList() {
    this.configService.getMemberList().subscribe((e) => {
      this.members = e;
      console.log(e);
    });
  }

  getCalendarEvents() {
    this.configService.getCalendarEvents().subscribe((e) => {
      this.events = e;
      console.log(e);
    });
  }

}


