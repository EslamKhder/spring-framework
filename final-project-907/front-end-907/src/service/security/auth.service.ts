import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl = 'http://localhost:9090/auth';
  constructor(private http: HttpClient) { }

  signup(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/sign-up', {username, password}).pipe(
      map(
        response => response
      )
    )
  }


  login(username, password): Observable<any> {
    return this.http.post<any>(this.baseUrl + '/login', {username, password}).pipe(
      map(
        response => response
      )
    )
  }


  isUserLogin(): boolean {
    const token = sessionStorage.getItem("token");
    return token && token.trim().length > 0;
  }

  logout(){
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("userName");
    sessionStorage.removeItem("userRoles");
  }
}

