import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
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

  // getConfig() {
  //   return this.http.get(this.configUrl);
  // }
  // // addUser(): Observable<Object>{
  // //   return this.http.post(this.addUserURL);
  // // }

  // async getUserInfo(){
  //   var result;
  //   var end = "http://localhost:8082/HighTechIndustries/member/" + sessionStorage.getItem("ID").toString();
  //   var paul = fetch(end).then(function (response) {return response.json() })
  //     .then(function (data) {
  //       result = data;
  //        return data;
  //     });
  //     await paul;
  //     return result;
  // }

  getUserInfo(): Observable<Object> {
    return this.http.get("http://localhost:8082/HighTechIndustries/member/" + sessionStorage.getItem("ID").toString());
  }

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
  // getUser(): Observable<Object>{
  //   return this.http.get(this.profileInfoURL)
  // }

  // getRecentlyViewed(): Observable<Object>{
  //   return this.http.get(this.recentlyViewedURL);
  // }

  // getProduct(): Observable<any>{
  //   return this.http.get(this.productURL);
  // }
  addUser(firstname, lastname, email, phone, username, password) {
    var end = "http://localhost:8082/HighTechIndustries/login/" + firstname + "/" + lastname + "/" + email + "/" + phone + "/Customer/" + username + "/" + password;
    fetch(end).then(function () { location.reload() });
  }

  logIn(username: String, password: String) {
    var end = "http://localhost:8082/HighTechIndustries/login/" + username + "/" + password;
    fetch(end).then(function (response) { return response.json() })
      .then(function (data) {
        sessionStorage.ID = data.id;
        sessionStorage.employeeStatus = data.employeeStatus;
        location.reload()
      });

    // getProduct(): any{
    //   console.log('in service');
    //   return this.http.get(this.productURL);
    // }
  }
}
