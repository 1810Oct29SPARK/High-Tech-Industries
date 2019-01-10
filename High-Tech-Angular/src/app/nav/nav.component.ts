import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor() { }

  // used to determine which button is listed on the nav
  // if the user is signed in then the sign out button will display and the sign in button will be disabled
  isEmployee: boolean = true;
  signedIn: boolean = true;
  signedOut: boolean = false;

  showEmployeeTab: boolean;

  ngOnInit() {
  }

}
