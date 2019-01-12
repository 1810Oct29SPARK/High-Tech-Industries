import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  constructor() { }

  noItems: boolean = true;
  areItems: boolean = false;


  showConfig() {
    this.configService.getConfig()
      .subscribe((data: Config) => this.config = {
        heroesUrl: data['heroesUrl'],
        textfile: data['textfile']
      });
  }


  ngOnInit() {
  }

}
