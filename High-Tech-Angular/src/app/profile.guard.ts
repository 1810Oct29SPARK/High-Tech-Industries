import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileGuard implements CanActivate {
  sessionId = sessionStorage.getItem("ID");
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(this.sessionId){
        return true;
      } else {
        window.alert("You are not logged in");
        window.location.href = 'http://localhost:4200/high-tech/news';
        return false;
      }
  }
}
