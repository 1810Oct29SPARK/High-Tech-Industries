import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';

// Jeremy

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(public configService: ConfigService) { }

  members: string[];

  showMembers: boolean = true;

  submitted = false;

  onSubmit() {
    this.submitted = true;
  }

  ngOnInit() {
    this.getCalendarEvents();
  }

  getCalendarEvents() {
    this.configService.getMemberList().subscribe((e) => {
      this.members = e;
      console.log(e);
    });
  }

}


