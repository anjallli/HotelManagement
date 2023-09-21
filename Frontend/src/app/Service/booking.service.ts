import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../booking';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private bookroom="http://localhost:8080/booking/addbooking";
  private book="http://localhost:8080/booking/list";

  constructor(private httpClient:HttpClient) { }
  getBookings():Observable<any>{

    return this.httpClient.get(this.book);

  }
  
  bookRoom(book:Booking):Observable<any>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpClient.post<Booking>(this.bookroom,book,httpOptions);
  }
}
