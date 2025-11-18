import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:6060/order';

  constructor(private http: HttpClient) {}

  createOrder(products): Observable<any>{
    return this.http.post<any>(this.baseUrl + "/create-order", {products}).pipe(
      map(
        response => response
      )
    );
  }
}
