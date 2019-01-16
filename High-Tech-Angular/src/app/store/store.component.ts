import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';

// Jeremy

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  constructor(public configService: ConfigService) { }

  noItems: boolean = true;
  areItems: boolean = false;





  ngOnInit(): void {
    // function getStoreItems() {
    //   const endpoint = "http://localhost:8082/HighTechIndustries/store/products";
    //   fetch(endpoint).then(function (response) { return response.json() })
    //     .then(function (data) { return data });
  }

  // var products = getStoreItems;
}
