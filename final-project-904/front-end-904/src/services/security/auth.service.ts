import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl = 'http://localhost:6060/auth/';

  constructor(private http: HttpClient) { }


  createAccount(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + "sign-up", {username, password}).pipe(
      map(
        response => response
      )
    );
  }

  login(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + "login", {username, password}).pipe(
      map(
        response => response
      )
    );
  }

  isUserLogin(){
    return sessionStorage.getItem("token");
  }

  isUserAdmin(){
    return sessionStorage.getItem("roles") && sessionStorage.getItem("roles").includes("ADMIN");
  }

  logOut(){
    sessionStorage.removeItem("userName");
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("roles");
  }
}
