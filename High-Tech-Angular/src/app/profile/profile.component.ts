import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
// import { ProfileInfoComponent } from '../profile-info/profile-info.component';
import { ConfigService } from '../config.service';
import { HttpClient } from '@angular/common/http';
// Jeremy

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor(private componentFactoryResolver: ComponentFactoryResolver, public configService: ConfigService,
    private http: HttpClient) { }

    events: any;
    purchased: String[];
    items: string[] = [];


// delare boolean values for the info and items on the profile page
  showInfo: boolean = true;
  showItems: boolean = false;
  user: any;
  // when each button is pressed it will change the related value to true and the unrelated value to false
  // if that value is true, that section of html will display on the page. 
  toggleInfo() {
    this.showInfo = true;
    this.showItems = false;
  }
  toggleItems() {
    this.showItems = true;
    this.showInfo = false;
  }

  getInfo(){
    this.configService.getUserInfo().subscribe ((e) => {
      this.user = e;
    });
  }
  ngOnInit() {
    this.getInfo();
    this.getCalendarEvents();
    this.getPurchasedItems();
  } 

  getCalendarEvents() {
    this.configService.getMemberEvents().subscribe( (e)=>{
      this.events = e;
      console.log(this.events);
    });
  }

  addMemberEvent(){
    var memberId = sessionStorage.getItem("ID").toString();
    var type = (<HTMLInputElement>document.getElementById("type")).value.toString();
    var date = (<HTMLInputElement>document.getElementById("date")).value.toString();
    var timeslot = (<HTMLInputElement>document.getElementById("timeslot")).value.toString();
    this.configService.addCalendarEvent(memberId, type, date, timeslot, 128).subscribe( (e) => {
    })
    location.reload();
  }

  deleteMemberEvent(value){
    this.configService.deleteCalendarEvent(value).subscribe( (data) => {
    })
    location.reload();
  }

  getPurchasedItems() {
    this.configService.getPruchasedItems().subscribe( (e)=>{
      this.purchased = e;
      for (let x=0; x<e.length; x++) {
        this.configService.getItem(e[x].productId).subscribe( (data) => {
          this.items[x] = data;
        })
      }
    });
  }

}
