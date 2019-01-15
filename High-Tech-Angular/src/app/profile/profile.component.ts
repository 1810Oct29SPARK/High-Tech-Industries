import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
import { ProfileInfoComponent } from '../profile-info/profile-info.component';
import { ConfigService } from '../config.service';
<<<<<<< HEAD
=======

// Jeremy

>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

<<<<<<< HEAD
  constructor(public componentFactoryResolver: ComponentFactoryResolver) { }
=======
  constructor(private componentFactoryResolver: ComponentFactoryResolver, public configService: ConfigService) { }
>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42

  firstname: String = 'Someone\'s Name';

// delare boolean values for the info and items on the profile page
  showInfo: boolean = true;
  showItems: boolean = false;
<<<<<<< HEAD

=======
  
  // when each button is pressed it will change the related value to true and the unrelated value to false
  // if that value is true, that section of html will display on the page. 
>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42
  toggleInfo() {
    this.showInfo = true;
    this.showItems = false;
  }
  toggleItems() {
    this.showItems = true;
    this.showInfo = false;
  }

<<<<<<< HEAD
  showConfig() {
    this.configService.getConfig()
      .subscribe((data: Config) => this.config = {
        loginURL: data['loginUrl']
      });
  }
=======
  user$ = this.configService.getUser()
>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42

  ngOnInit() {
  }

}
