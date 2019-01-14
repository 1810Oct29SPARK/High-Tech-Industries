import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
import { ProfileInfoComponent } from '../profile-info/profile-info.component';
import { ConfigService } from '../config.service';

// Jeremy


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private componentFactoryResolver: ComponentFactoryResolver, public configService: ConfigService) { }

  firstname: String = 'Someone\'s Name';

// delare boolean values for the info and items on the profile page
  showInfo: boolean = true;
  showItems: boolean = false;
  
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

  user$ = this.configService.getUser()

  ngOnInit() {
  }

}
