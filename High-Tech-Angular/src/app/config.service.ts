import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

// Jeremy

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) { }



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

  addCalendarEvent(memberId, type, date, timeslot, helpedBy): Observable<any>{
    if(helpedBy == null){
      helpedBy = 1;
    }
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/addEvent/'+memberId+"/"+type+"/"+date+"/"+timeslot+"/"+helpedBy);
  }

  getMemberEvents(){
    return this.http.get('http://localhost:8082/HighTechIndustries/calendar/memberEvents/'+sessionStorage.getItem("ID").toString());
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

  getAllPurchasedItems(): Observable<any> {
    return this.http.get('http://localhost:8082/HighTechIndustries/store/purchased');
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
