import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';

// Jeremy

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public configService: ConfigService) { }

  members: string[];
  events: string[];
  purchased: string[];
  item: string[] = [];

  showMembers: boolean = true;

  submitted = false;


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


