import { Component } from '@angular/core';
import { NgbDateStruct, NgbCalendar } from '@ng-bootstrap/ng-bootstrap';
import { ConfigService } from '../config.service';

// Jeremy

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent {

  model: NgbDateStruct;
  date: { year: number, month: number };
  allEvents: any;

  constructor(private calendar: NgbCalendar, public configService: ConfigService) { }


  selectToday() {
    this.model = this.calendar.getToday();
  }

  getEvents(){
    this.configService.getAllEvents().subscribe( (data) => {
      this.allEvents = data;
      console.log(this.allEvents);
    })
  }

  OnInit() {
    // this.getEvents();
  }
}
