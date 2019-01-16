import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';

// Jeremy

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  products: string[];

  constructor(public configService: ConfigService) { }

  noItems: boolean = true;
  areItems: boolean = false;
  recentlyViewedList$ = this.configService.getRecentlyViewed();

  ngOnInit() {
    this.getProductsFromStore();
  }

  getProductsFromStore() {
    this.configService.getProduct().subscribe( (e)=>{
      this.products = e;
      console.log(e);
    });
  }

  // var products = getStoreItems;
}
