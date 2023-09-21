import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private loginurl = "http://localhost:8080/customer/login";
  private baseurl="http://localhost:8080/customer/list";
  private addcus="http://localhost:8080/customer/addCustomer";
  private  cusfind="http://localhost:8080/customer/findCustomer";
  private cusupdate="http://localhost:8080/customer/updateCustomer";
  private custdel="http://localhost:8080/customer/deleteCustomer";
  constructor(private httpClient:HttpClient) { }

  getCustomer():Observable<any>{

    return this.httpClient.get(this.baseurl);

  }

  getlogin(user: Customer): Observable<Customer> {
    console.log(user);
    return this.httpClient.post<Customer>(`${this.loginurl}`, user);
  }
  
  SaveEmployee(customer:Customer):Observable<any>
  {
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpClient.post<Customer>(this.addcus,customer,httpOptions);
  }

  

  getCustomerById(id:number):Observable<Customer>{
    
  const empIDURl=this.cusfind+"/"+id;
  return  this.httpClient.get<Customer>(empIDURl);
  }
  updateCustomer(customer:Customer):Observable<Object>{
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpClient.put<Customer>(this.cusupdate,customer,httpOptions);
  }

  deleteCustomer(id: Number) {
   
    const httpOptions = {
      headers : new HttpHeaders({
          'Content-Type' : 'application/json',
          'Authorization' : 'auth-token',
          'Access-Control-Allow-Origin' : '*'
      })
    };
    return  this.httpClient.delete<Customer>(this.custdel+`/${id}`,httpOptions);
  }
}
  

