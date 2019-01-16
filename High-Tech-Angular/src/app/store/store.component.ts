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

<<<<<<< HEAD

  ngOnInit() {
    
=======
  products: any;

  getProducts() {
    this.configService.getProduct()
      .subscribe((data) => {
        this.products = data;
        console.log(data);
      })
  }





  ngOnInit(): void {
    // function getStoreItems() {
    //   const endpoint = "http://localhost:8082/HighTechIndustries/store/products";
    //   fetch(endpoint).then(function (response) { return response.json() })
    //     .then(function (data) { return data });
    this.getProducts();
>>>>>>> 02978b03c58bc96e7b6a0c4ccc4ec5f7bcecce5c
  }

  // var products = getStoreItems;
}
