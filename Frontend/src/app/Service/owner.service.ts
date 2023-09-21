import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Owner } from '../owner';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  


  private loginurl = "http://localhost:8080/owner/login";
  private userUrl="http://localhost:8080/owner/list";
  private newuserurl = "http://localhost:8080/owner/saveuser";
  constructor(private httpClient: HttpClient) 
  {

   }

    getlogin(user: Owner): Observable<Owner> {
    console.log(user);
    return this.httpClient.post<Owner>(`${this.loginurl}`, user);
    }

  

  getuserbyid(uid: number):Observable<Owner>  {
    const uidUrl = this.userUrl + "/" + uid;
    return this.httpClient.get<Owner>(uidUrl);
  }


  
  
  updateUser(user: Owner): Observable<Owner> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.httpClient.put<Owner>(this.userUrl + `/${user.ownerId}`, user, httpOptions);
  }

  
  ///user Maintainance

  saveUser(user: Owner): Observable<Owner> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.httpClient.post<Owner>(this.newuserurl, user, httpOptions);
  }
}
