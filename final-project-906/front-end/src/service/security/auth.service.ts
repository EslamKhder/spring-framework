import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = 'http://localhost:6060/auth';

  constructor(private http: HttpClient) {}

  login(username, password): Observable<any>{
    return this.http.post<any>(this.baseUrl + "/login", {username, password}).pipe(
      map(
        response => response
      )
    );
  }


  signup(username, password): Observable<any>{
    return this.http.post<any>(this.baseUrl + "/sign-up", {username, password}).pipe(
      map(
        response => response
      )
    );
  }

  isUserLogin(): boolean {
    return sessionStorage.getItem("token") !== null &&
              sessionStorage.getItem("token") !== undefined &&
                          sessionStorage.getItem("token") !== "";
  }

  logout(){
    sessionStorage.removeItem("token");
  }

}
