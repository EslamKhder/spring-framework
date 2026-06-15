import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = "http://localhost:6060/auth";

  constructor(private http: HttpClient) {
  }

  private authenticate(endpoint: string, username: string, password: string): Observable<any> {
    return this.http.post<any>(
      this.baseUrl + endpoint,
      { username, password }
    );
  }

  login(username: string, password: string): Observable<any> {
    return this.authenticate('/login', username, password);
  }

  signup(username: string, password: string): Observable<any> {
    return this.authenticate('/sign-up', username, password);
  }

  isUserLogin(): boolean{
    return sessionStorage.getItem("token") !== null && sessionStorage.getItem("token") !== undefined && sessionStorage.getItem("token") !== "";
  }
  logout(){
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("roles");
  }
}
