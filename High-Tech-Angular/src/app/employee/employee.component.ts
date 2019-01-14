import { Component, OnInit } from '@angular/core';

// Jeremy

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor() { }

  showMembers: boolean = true;

  submitted = false;

  onSubmit(){
    this.submitted = true;
    console.log("hello");
  }

  ngOnInit() {
  }

}
