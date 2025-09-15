import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:9090/auth';  // login   signup
  constructor(private http: HttpClient) {
  }


  createAccount(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + "/sign-up", {username, password}).pipe(
      map(
        response => response
      )
    )
  }

  login(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + "/login", {username, password}).pipe(
      map(
        response => response
      )
    )
  }

  isUserLogin(): boolean {
    return sessionStorage.getItem("token") != null &&
                     sessionStorage.getItem("token") != undefined;
  }

  isAdmin(): boolean {
    debugger
    const roles = sessionStorage.getItem("roles");
    if (!roles) {
      return false;
    }

    return roles.includes("ADMIN");
  }

  logOut() {
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("roles");
  }


}
