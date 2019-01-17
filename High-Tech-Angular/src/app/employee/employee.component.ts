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
  purchased: string[];
  item: string[] = [];

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

  // delare boolean values for the info and items on the profile page
    showMemList: boolean = true;
    showPurchased: boolean = false;
    // when each button is pressed it will change the related value to true and the unrelated value to false
    // if that value is true, that section of html will display on the page. 
    toggleInfo() {
      this.showMemList = true;
      this.showPurchased = false;
    }
    toggleItems() {
      this.showPurchased = true;
      this.showMemList = false;
    }

  onSubmit() {
    this.submitted = true;
  }

  ngOnInit() {
    this.getMemberList();
    this.getCalendarEvents();
    this.getEvents();
    this.getAllPurchasedItems();
  }

  getMemberList() {
    this.configService.getMemberList().subscribe((e) => {
      this.members = e;
    });
  }

  getCalendarEvents() {
    this.configService.getCalendarEvents().subscribe((e) => {
      this.events = e;
    });
  }

  getAllPurchasedItems() {
    this.configService.getAllPurchasedItems().subscribe((e) => {
      this.purchased = e;
      for (let x=0; x<e.length; x++) {
        this.configService.getItem(e[x].productId).subscribe( (data) => {
          this.item[x] = data;
        })
      }
    });
  }

}


