import { HttpClient, HttpResponse, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Calendar } from './calendar';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';

//Sean

@Injectable()
export class CalendarService{

    constructor(private _httpService: HttpClient){}

    getAllEvents(): Observable<Calendar[]>{
        return this._httpService.get("http:localhost:8082/HighTechIndustries/calendar/memberEvents/{memberId}")
            .pipe(map((response: Response) => response.json()))
            .source.pipe(catchError(this.handleError));
    }

    private handleError(error: Response){
        return Observable.throw(error);
    }
}