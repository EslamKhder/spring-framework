import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl = 'http://localhost:9090/order/create-order';
  constructor(private http: HttpClient) { }

  takeOrder(orderVms): Observable<any> {
    return this.http.post<any>(this.baseUrl , {orderVms}).pipe(
      map(
        response => response
      )
    )
  }
}
