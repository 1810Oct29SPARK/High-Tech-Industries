import { Component, OnInit, Input } from '@angular/core';
import { ConfigService } from '../config.service';
import { HttpParams } from '@angular/common/http';

// Jeremy

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public configService: ConfigService) { }

  // used to determine which button is listed on the nav
  // if the user is signed in then the sign out button will display and the sign in button will be disabled
  isEmployee: boolean = false;
  signedIn: boolean = false;
  signedOut: boolean = true;

  username: String;
  password: String;
  HttpParams: String[];

  showEmployeeTab(){
    if(sessionStorage.getItem('employeeStatus') == 'Employee'){
      this.isEmployee = true;
    }
  }

  showProfileTab(){
    if(sessionStorage.getItem('ID')){
      //console.log(sessionStorage.ID);
      this.signedIn = true;
      this.signedOut = false;
    }
  }

  signOut(){
    sessionStorage.clear();
    window.location.href = 'http://localhost:4200/high-tech/news';
  }

  signIn(){
    var username = (<HTMLInputElement>document.getElementById("usernamesignin")).value.toString();
    var password = (<HTMLInputElement>document.getElementById("passwordsignin")).value.toString();
    this.configService.logIn(username, password);
  }

  addingUser(){
    var firstname = (<HTMLInputElement>document.getElementById("createFirstname")).value.toString();
    var lastname = (<HTMLInputElement>document.getElementById("createLastname")).value.toString();
    var email = (<HTMLInputElement>document.getElementById("createEmail")).value.toString();
    var phone = (<HTMLInputElement>document.getElementById("createPhone")).value.toString();
    var username = (<HTMLInputElement>document.getElementById("createUsername")).value.toString();
    var password = (<HTMLInputElement>document.getElementById("createPassword")).value.toString();
    this.configService.addUser(firstname, lastname, email, phone, username, password);
  }


  ngOnInit() {
    this.showEmployeeTab();
    this.showProfileTab();
  }

}
