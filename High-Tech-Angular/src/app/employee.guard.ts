import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeGuard implements CanActivate {
  sessionStatus = sessionStorage.getItem("employeeStatus");
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.sessionStatus) {
      if (this.sessionStatus.toString() == "Employee") {
        return true;
      } else {
        window.alert("You are not an employee");
        window.location.href = 'http://localhost:4200/high-tech/news';
        return false;
      }
    } else {
      window.alert("You are not logged in");
      window.location.href = 'http://localhost:4200/high-tech/news';    
      return false;
    }
  }
}
