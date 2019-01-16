import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Jeremy

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  configUrl = 'assets/config.json';
  profileInfoURL: "http://localhost:8082/HighTechIndustries/member/{memberId}";
  addUserURL: "http://localhost:8082/HighTechIndustries/login/addUser";
  recentlyViewedURL: "http://localhost:8082/HighTechIndustries/store/";
  productURL: 'http://localhost:8082/HighTechIndustries/store/products';

  // getConfig() {
  //   return this.http.get(this.configUrl);
  // }
  
  // addUser(): Observable<Object>{
  //   return this.http.post(this.addUserURL);
  // }

  getUser(): Observable<any>{
    return this.http.get(this.profileInfoURL)
  }

  getRecentlyViewed(): Observable<any>{
    return this.http.get(this.recentlyViewedURL);
  }

  getMemberList(): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/member/allMembers');
  }

  getCalendarEvents(): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/allEvents');
  }

  getProduct(): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/store/products');
  }
}
