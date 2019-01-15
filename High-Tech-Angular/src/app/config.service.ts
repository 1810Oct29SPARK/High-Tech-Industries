import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
<<<<<<< HEAD
=======
import { Observable } from 'rxjs';

// Jeremy
>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }

  configUrl = 'assets/config.json';
<<<<<<< HEAD
=======
  profileInfoURL: "http://localhost:8082/HighTechIndustries/member/{memberId}";
  addUserURL: "http://localhost:8082/HighTechIndustries/login/addUser";
  recentlyViewedURL: "http://localhost:8082/HighTechIndustries/store/";
  productURL: "http://localhost:8082/HighTechIndustries/store/";
>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42

  getConfig() {
    return this.http.get(this.configUrl);
  }

<<<<<<< HEAD
=======
  // addUser(): Observable<Object>{
  //   return this.http.post(this.addUserURL);
  // }

  getUser(): Observable<Object>{
    return this.http.get(this.profileInfoURL)
  }

  getRecentlyViewed(): Observable<Object>{
    return this.http.get(this.recentlyViewedURL);
  }

  getProduct(): Observable<Object>{
    return this.http.get(this.productURL);
  }

>>>>>>> baf910032671d0d6897c207a62d9b6277e12dc42
}
