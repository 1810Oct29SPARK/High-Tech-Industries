import { Component, OnInit, ViewChild, ComponentFactoryResolver } from '@angular/core';
import { ProfileInfoComponent } from '../profile-info/profile-info.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private componentFactoryResolver: ComponentFactoryResolver) { }

  showVar: boolean = true;
  toggleChild() {
    this.showVar = !this.showVar;
  }


  ngOnInit() {
  }

}
