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

  constructor(private calendar: NgbCalendar, public configService: ConfigService) { }

  events: string[];

  selectToday() {
    this.model = this.calendar.getToday();
  }

  OnInit() {
    this.getCalendarEvents();
  }

  getCalendarEvents() {
    this.configService.getCalendarEvents().subscribe((e) => {
      this.events = e;
      console.log(e);
    });
  }
}
