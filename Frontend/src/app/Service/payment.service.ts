import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentServiceService {
  private pay="http://localhost:8080/payment/addPayment";
  private paylist="http://localhost:8080/payment/list";

  constructor(private httpClient:HttpClient) { }
  getPayment():Observable<any>{

    return this.httpClient.get(this.paylist);

  }
  
  payment(payment:Payment):Observable<any>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpClient.post<Payment>(this.pay,payment,httpOptions);
  }

}
