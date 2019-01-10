import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor() { }

  isEmployee: boolean = true;
  signedIn: boolean = true;
  signedOut: boolean = false;

  showEmployeeTab: boolean;

  ngOnInit() {
  }

}
