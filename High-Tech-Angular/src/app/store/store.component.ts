import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { DomSanitizer } from '@angular/platform-browser';

// Jeremy

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  products: string[];
  recently: string[];
  recentlyViewed: string[] = [];
  cartList: string[] = [];
  cartQuantity: number = 0;
  quantity: string[] = [];

  constructor(public configService: ConfigService, public sanitizer: DomSanitizer) { }

  noItems: boolean = true;
  areItems: boolean = false;

  ngOnInit() {
    this.getProductsFromStore();
    this.getRecentlyViewed();
    this.getCartProducts();
  }

  getProductsFromStore() {
    this.configService.getProduct().subscribe((e) => {
      this.products = e;
    });
  }

  getCartProducts() {
    this.configService.getCart(sessionStorage.getItem("ID")).subscribe((e) => {
      for (let x = 0; x < e.length; x++) {
        this.configService.getStoreItem(e[x].productId).subscribe( (data) => {
          this.cartList[x] = data;
          this.quantity[x] = e[x].quantity;
          this.cartQuantity += (e[x].quantity)/1;
        })
      }
    })
  }

  checkCart(){
    if(this.cartList.length > 0){
      this.areItems = true;
      this.noItems = false;
    }
    console.log("something");
  }

  buyItems() {
    this.configService.buy(sessionStorage.getItem("ID"));
  }

  getRecentlyViewed() {
    this.configService.getRecentlyViewed().subscribe((e) => {
      if (e.productId1 == null) {
        return;
      }
      this.configService.getStoreItem(e.productId1).subscribe((data1) => {
        // this.picture = this.sanitizer.bypassSecurityTrustResourceUrl(data1.pic);
        this.recentlyViewed[0] = data1;
        if (e.productId2 == null) {
          return;
        }
        this.configService.getStoreItem(e.productId2).subscribe((data2) => {
          // this.picture = data2.pic;
          this.recentlyViewed[1] = data2;
          if (e.productId3 == null) {
            return;
          }
          this.configService.getStoreItem(e.productId3).subscribe((data3) => {
            this.recentlyViewed[2] = data3;
            if (e.productId4 == null) {
              return;
            }
            this.configService.getStoreItem(e.productId4).subscribe((data4) => {
              this.recentlyViewed[3] = data4;
              if (e.productId5 == null) {
                return;
              }
              this.configService.getStoreItem(e.productId5).subscribe((data5) => {
                this.recentlyViewed[4] = data5;
              })
            })
          })
        })
      })
    })
  }

}
