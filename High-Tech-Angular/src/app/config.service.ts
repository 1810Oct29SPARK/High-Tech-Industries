import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Jeremy

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  id = 7;
  productId = 10;
  configUrl = 'assets/config.json';
  profileInfoURL: "http://localhost:8082/HighTechIndustries/member/{memberId}";
  addUserURL: "http://localhost:8082/HighTechIndustries/login/addUser";
  recentlyViewedURL: "http://localhost:8082/HighTechIndustries/store/";
  productURL: "http://localhost:8082/HighTechIndustries/store/";

  getConfig() {
    return this.http.get(this.configUrl);
  }

  // addUser(): Observable<Object>{
  //   return this.http.post(this.addUserURL);
  // }

  getUser(): Observable<Object>{
    return this.http.get(this.profileInfoURL)
  }

  getRecentlyViewed(): Observable<Object>{
    return this.http.get(this.recentlyViewedURL.concat(this.id.toString()));
  }

  getProduct(): Observable<Object>{
    return this.http.get(this.productURL.concat(this.productId.toString()));
  }

}
