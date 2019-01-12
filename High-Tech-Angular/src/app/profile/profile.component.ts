import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
import { ProfileInfoComponent } from '../profile-info/profile-info.component';
import { ConfigService } from '../config.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(public componentFactoryResolver: ComponentFactoryResolver) { }

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

  showConfig() {
    this.configService.getConfig()
      .subscribe((data: Config) => this.config = {
        loginURL: data['loginUrl']
      });
  }

  ngOnInit() {
  }

}
