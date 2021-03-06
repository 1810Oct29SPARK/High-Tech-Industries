import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-profile-info',
  templateUrl: './profile-info.component.html',
  styleUrls: ['./profile-info.component.css']
})

export class ProfileInfoComponent implements OnInit {

  constructor() { }

  firstname: String = 'Someone\'s Name';

  @Input() profileInfo: boolean;
  @Input() profileItems: boolean;

  ngOnInit() {
  }

}
