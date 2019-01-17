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


  getUserInfo(): Observable<Object> {
    return this.http.get("http://localhost:8082/HighTechIndustries/member/" + sessionStorage.getItem("ID").toString());
  }

  // addUser(): Observable<Object>{
  //   return this.http.post(this.addUserURL);
  // }

  getUser(memberId): Observable<any> {
    return this.http.get("http://localhost:8082/HighTechIndustries/member/" + memberId.toString());
  }

  getRecentlyViewed(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/store/'+sessionStorage.getItem("ID").toString());
  }

  getStoreItem(productId): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/store/item'+productId.toString());
  }

  getCart(memberId): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/store/cart'+memberId.toString());
  }

  deleteCalendarEvent(eventId): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/deleteEvent'+eventId.toString());
  }

  getAllEvents(): Observable<any>{
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/allEvents');
  }

  getMemberList(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/member/allMembers');
  }

  getCalendarEvents(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/allEvents');
  }

  getProduct(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/store/products');
  }

  getItem(itemNum): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/store/item' + itemNum);
  }

  getPruchasedItems(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/member/purchased' + sessionStorage.getItem("ID").toString());
  }

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
  }
}
