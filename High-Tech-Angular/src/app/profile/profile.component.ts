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

    events: String[];
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
      console.log(e);
    });
  }
  ngOnInit() {
    this.getInfo();
    this.getCalendarEvents();
    this.getPurchasedItems();
  } 

  getCalendarEvents() {
    this.configService.getCalendarEvents().subscribe( (e)=>{
      this.events = e;
      this.configService.getUserInfo().subscribe( (e => {
        this.user = e;
      }))
      console.log(e);
    });
  }

  getPurchasedItems() {
    this.configService.getPruchasedItems().subscribe( (e)=>{
      this.purchased = e;
      console.log(e);
      for (let x=0; x<e.length; x++) {
        this.configService.getItem(e[x].productId).subscribe( (data) => {
          this.items[x] = data;
          console.log(data);
        })
      }
    });
  }

}
