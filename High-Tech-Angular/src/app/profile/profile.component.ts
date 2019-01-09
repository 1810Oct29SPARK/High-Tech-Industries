import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
import { ProfileInfoComponent } from '../profile-info/profile-info.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private componentFactoryResolver: ComponentFactoryResolver) { }

  firstname: String = 'Someone\'s Name';


  showInfo: boolean = true;
  showItems: boolean = false;
  
  toggleInfo() {
    this.showInfo = true;
    this.showItems = false;
  }
  toggleItems() {
    this.showItems = true;
    this.showInfo = false;
  }

  ngOnInit() {
  }

}
