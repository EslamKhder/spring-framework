import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseURL = 'http://localhost:6060/auth';
  constructor(private httpClient: HttpClient) { }

  signup(username, password): Observable<any> {
    return this.httpClient.post<any>(this.baseURL + "/sign-up", {username, password}).pipe(
      map(
        response => response
      )
    );
  }
  login(username, password): Observable<any> {
    return this.httpClient.post<any>(this.baseURL + "/login", {username, password}).pipe(
      map(
        response => response
      )
    );
  }
}
