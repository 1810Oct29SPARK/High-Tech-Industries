import { Component, OnInit } from '@angular/core';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { CalendarService } from './calendar.service';
import { Calendar } from './calendar';

// Jeremy, Sean

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css']
})
export class CalendarComponent implements OnInit {

  model: NgbDateStruct;
  date: {year: number, month: number};

  // constructor(private calendar: NgbCalendar) {
  // }
  events: Calendar[];
  constructor(private _calendarService: CalendarService){}

  ngOnInit(): void{
    this.getEvents();
  }

  getEvents(): void{
    this._calendarService.getAllEvents()
      .subscribe((calendarData) => {this.events = calendarData, console.log(calendarData)}, (error) => {
        console.log(error);
      })
    }

  // selectToday() {
  //   this.model = this.calendar.getToday();
  // }

  OnInit(){

  }
}
