import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:8085/client'; // /create-client   /login
  constructor(private http: HttpClient) { }


  createAccount(name, phoneNumber, email, password): Observable<any> {
    return this.http.post(this.baseUrl + '/create-client', {name, email, phoneNumber, password}).pipe(
      map(
        response => response
      )
    )
  }

  login(email, password): Observable<any> {
    return this.http.post(this.baseUrl + '/login', {email, password}).pipe(
      map(
        response => response
      )
    )
  }

  isUserLogIn(){
    return sessionStorage.getItem('token') != null &&  sessionStorage.getItem('token') != undefined;
  }

}
