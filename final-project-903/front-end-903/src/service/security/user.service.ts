import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = 'http://localhost:6060/auth/';
  constructor(private http: HttpClient) { }

  createAccount(username, password): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}sign-up`, {username, password}).pipe(
      map(
        response => response
      )
    )
  }

  login(username, password): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}login`, {username, password}).pipe(
      map(
        response => response
      )
    )
  }

}
