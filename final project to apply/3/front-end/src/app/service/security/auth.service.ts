import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  createClientUrl = 'http://localhost:9090/client/create-client';
  loginClientUrl = 'http://localhost:9090/client/login';
  constructor(private http: HttpClient) { }


  createClient(email, password): Observable<any> {
    return this.http.post(this.createClientUrl, {email, password}).pipe(
      map(
        response => response
      )
    )
  }

  loginClient(email, password): Observable<any> {
    return this.http.post(this.loginClientUrl, {email, password}).pipe(
      map(
        response => response
      )
    )
  }

  isUserLogin(){
    return sessionStorage.getItem("token") !== null && sessionStorage.getItem("token") !== undefined;
  }

  logOutClient(){
    sessionStorage.removeItem("token")
  }
}
